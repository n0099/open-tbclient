package com.baidu.tieba.godRecommends;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a Td;
    private a eod;
    private ViewGroup eoj;
    private com.baidu.tieba.godRecommends.a eok;
    private TextView eol;
    private View eom;
    private TextView eon;
    private View eoo;
    private TextView eop;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> eoq = new ArrayList();
    private List<MetaData> eor = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aJB()) {
                if (!d.this.cf(d.this.eoq)) {
                    d.this.eok.setData(d.this.eoq);
                } else {
                    d.this.Tb();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void cc(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.eod = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.I(cVar.aJy())) {
            Tb();
            this.eoq.clear();
            this.eor.clear();
            List<MetaData> aJy = cVar.aJy();
            int size = aJy.size();
            if (size <= 3) {
                this.eoq.addAll(aJy);
            } else {
                this.eoq.addAll(aJy.subList(0, 3));
                this.eor.addAll(aJy.subList(3, size));
            }
            initUI();
            this.eol.setText(e.j.god_recommend_title);
            al.i(this.eoj, e.f.bg_god_recommend_layout);
            al.h(this.eol, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.eom, e.d.cp_bg_line_a);
            al.h(this.eon, e.d.cp_cont_f);
            al.i(this.eon, e.f.god_recommend_left_button_selector);
            al.j(this.eoo, e.d.cp_bg_line_a);
            al.h(this.eop, e.d.cp_link_tip_a);
            al.i(this.eop, e.f.god_recommend_right_button_selertor);
            this.eok.setData(this.eoq);
            this.mListView.setAdapter((ListAdapter) this.eok);
            this.Td.reset();
            this.Td.b(this.mContext).BF();
        }
    }

    private void initUI() {
        if (this.eoj == null) {
            this.eoj = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.eol = (TextView) this.eoj.findViewById(e.g.god_title);
            this.mTopLine = this.eoj.findViewById(e.g.top_line);
            this.eom = this.eoj.findViewById(e.g.content_button_divider);
            this.eon = (TextView) this.eoj.findViewById(e.g.btn_to_do_leter);
            this.eon.setOnClickListener(this);
            this.eoo = this.eoj.findViewById(e.g.button_divider);
            this.eop = (TextView) this.eoj.findViewById(e.g.btn_attention_all);
            this.eop.setOnClickListener(this);
            this.mListView = (ListView) this.eoj.findViewById(e.g.listview);
            this.eok = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.eok.setOnClickListener(this.mOnClickListener);
        }
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Td.G(this.eoj);
            this.Td.dd(1);
            this.Td.bg(true);
        }
    }

    private List<MetaData> aJz() {
        if (v.I(this.eoq)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.eoq) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData oh(int i) {
        return this.eok.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.I(list) && aJB()) {
            boolean ce = ce(list);
            if (z) {
                if (ce) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    Tb();
                    return;
                }
                this.eok.setData(this.eoq);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (ce) {
                this.eok.setData(this.eoq);
                aJA();
            } else {
                l.showToast(this.mActivity, cd(list));
            }
        }
    }

    private String cd(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.I(list)) {
            str = null;
        } else {
            for (MFollowResult mFollowResult : list) {
                if (mFollowResult == null || mFollowResult.is_success.booleanValue()) {
                    str2 = str3;
                    i = i2;
                } else {
                    i = i2 + 1;
                    str2 = mFollowResult.msg;
                }
                i2 = i;
                str3 = str2;
            }
            str = str3;
        }
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(e.j.attention_fail) : str;
    }

    private void aJA() {
        if (!v.I(this.eor)) {
            int size = this.eoq.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.eoq.get(size) == null || !this.eoq.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.eoq.remove(size);
                        this.eoq.add(this.eor.remove(0));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean ce(List<MFollowResult> list) {
        if (v.I(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.eoq.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MetaData next = it.next();
                        String str = mFollowResult.portrait;
                        if (next != null && str != null && str.equals(next.getPortrait())) {
                            next.getGodUserData().setIsLike(true);
                            break;
                        }
                    }
                }
            }
            z = z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cf(List<MetaData> list) {
        if (!v.I(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJB() {
        return this.Td != null && this.Td.isShowing();
    }

    public void Tb() {
        if (aJB()) {
            this.Td.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.btn_to_do_leter) {
            this.Td.dismiss();
        }
        if (id == e.g.btn_attention_all && this.eod != null) {
            this.eod.cc(aJz());
        }
    }
}
