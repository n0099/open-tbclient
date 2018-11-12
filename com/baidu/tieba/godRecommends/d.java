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
    private a ehk;
    private ViewGroup ehp;
    private com.baidu.tieba.godRecommends.a ehq;
    private TextView ehr;
    private View ehs;
    private TextView eht;
    private View ehu;
    private TextView ehv;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> ehw = new ArrayList();
    private List<MetaData> ehx = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aHK()) {
                if (!d.this.cb(d.this.ehw)) {
                    d.this.ehq.setData(d.this.ehw);
                } else {
                    d.this.RV();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bY(List<MetaData> list);
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
        this.ehk = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.I(cVar.aHH())) {
            RV();
            this.ehw.clear();
            this.ehx.clear();
            List<MetaData> aHH = cVar.aHH();
            int size = aHH.size();
            if (size <= 3) {
                this.ehw.addAll(aHH);
            } else {
                this.ehw.addAll(aHH.subList(0, 3));
                this.ehx.addAll(aHH.subList(3, size));
            }
            initUI();
            this.ehr.setText(e.j.god_recommend_title);
            al.i(this.ehp, e.f.bg_god_recommend_layout);
            al.h(this.ehr, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.ehs, e.d.cp_bg_line_a);
            al.h(this.eht, e.d.cp_cont_f);
            al.i(this.eht, e.f.god_recommend_left_button_selector);
            al.j(this.ehu, e.d.cp_bg_line_a);
            al.h(this.ehv, e.d.cp_link_tip_a);
            al.i(this.ehv, e.f.god_recommend_right_button_selertor);
            this.ehq.setData(this.ehw);
            this.mListView.setAdapter((ListAdapter) this.ehq);
            this.Td.reset();
            this.Td.b(this.mContext).AB();
        }
    }

    private void initUI() {
        if (this.ehp == null) {
            this.ehp = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.ehr = (TextView) this.ehp.findViewById(e.g.god_title);
            this.mTopLine = this.ehp.findViewById(e.g.top_line);
            this.ehs = this.ehp.findViewById(e.g.content_button_divider);
            this.eht = (TextView) this.ehp.findViewById(e.g.btn_to_do_leter);
            this.eht.setOnClickListener(this);
            this.ehu = this.ehp.findViewById(e.g.button_divider);
            this.ehv = (TextView) this.ehp.findViewById(e.g.btn_attention_all);
            this.ehv.setOnClickListener(this);
            this.mListView = (ListView) this.ehp.findViewById(e.g.listview);
            this.ehq = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.ehq.setOnClickListener(this.mOnClickListener);
        }
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Td.G(this.ehp);
            this.Td.cP(1);
            this.Td.bf(true);
        }
    }

    private List<MetaData> aHI() {
        if (v.I(this.ehw)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.ehw) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData nN(int i) {
        return this.ehq.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.I(list) && aHK()) {
            boolean ca = ca(list);
            if (z) {
                if (ca) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    RV();
                    return;
                }
                this.ehq.setData(this.ehw);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (ca) {
                this.ehq.setData(this.ehw);
                aHJ();
            } else {
                l.showToast(this.mActivity, bZ(list));
            }
        }
    }

    private String bZ(List<MFollowResult> list) {
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

    private void aHJ() {
        if (!v.I(this.ehx)) {
            int size = this.ehw.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.ehw.get(size) == null || !this.ehw.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.ehw.remove(size);
                        this.ehw.add(this.ehx.remove(0));
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

    private boolean ca(List<MFollowResult> list) {
        if (v.I(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.ehw.iterator();
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
    public boolean cb(List<MetaData> list) {
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
    public boolean aHK() {
        return this.Td != null && this.Td.isShowing();
    }

    public void RV() {
        if (aHK()) {
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
        if (id == e.g.btn_attention_all && this.ehk != null) {
            this.ehk.bY(aHI());
        }
    }
}
