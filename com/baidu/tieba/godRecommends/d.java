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
    private a eqU;
    private ViewGroup eqZ;
    private com.baidu.tieba.godRecommends.a era;
    private TextView erb;
    private View erc;
    private TextView erd;
    private View ere;
    private TextView erf;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> erg = new ArrayList();
    private List<MetaData> erh = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aKq()) {
                if (!d.this.cg(d.this.erg)) {
                    d.this.era.setData(d.this.erg);
                } else {
                    d.this.Td();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void cd(List<MetaData> list);
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
        this.eqU = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.I(cVar.aKn())) {
            Td();
            this.erg.clear();
            this.erh.clear();
            List<MetaData> aKn = cVar.aKn();
            int size = aKn.size();
            if (size <= 3) {
                this.erg.addAll(aKn);
            } else {
                this.erg.addAll(aKn.subList(0, 3));
                this.erh.addAll(aKn.subList(3, size));
            }
            initUI();
            this.erb.setText(e.j.god_recommend_title);
            al.i(this.eqZ, e.f.bg_god_recommend_layout);
            al.h(this.erb, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.erc, e.d.cp_bg_line_a);
            al.h(this.erd, e.d.cp_cont_f);
            al.i(this.erd, e.f.god_recommend_left_button_selector);
            al.j(this.ere, e.d.cp_bg_line_a);
            al.h(this.erf, e.d.cp_link_tip_a);
            al.i(this.erf, e.f.god_recommend_right_button_selertor);
            this.era.setData(this.erg);
            this.mListView.setAdapter((ListAdapter) this.era);
            this.Td.reset();
            this.Td.b(this.mContext).BF();
        }
    }

    private void initUI() {
        if (this.eqZ == null) {
            this.eqZ = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.erb = (TextView) this.eqZ.findViewById(e.g.god_title);
            this.mTopLine = this.eqZ.findViewById(e.g.top_line);
            this.erc = this.eqZ.findViewById(e.g.content_button_divider);
            this.erd = (TextView) this.eqZ.findViewById(e.g.btn_to_do_leter);
            this.erd.setOnClickListener(this);
            this.ere = this.eqZ.findViewById(e.g.button_divider);
            this.erf = (TextView) this.eqZ.findViewById(e.g.btn_attention_all);
            this.erf.setOnClickListener(this);
            this.mListView = (ListView) this.eqZ.findViewById(e.g.listview);
            this.era = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.era.setOnClickListener(this.mOnClickListener);
        }
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Td.G(this.eqZ);
            this.Td.dd(1);
            this.Td.bg(true);
        }
    }

    private List<MetaData> aKo() {
        if (v.I(this.erg)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.erg) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ou(int i) {
        return this.era.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.I(list) && aKq()) {
            boolean cf = cf(list);
            if (z) {
                if (cf) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    Td();
                    return;
                }
                this.era.setData(this.erg);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (cf) {
                this.era.setData(this.erg);
                aKp();
            } else {
                l.showToast(this.mActivity, ce(list));
            }
        }
    }

    private String ce(List<MFollowResult> list) {
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

    private void aKp() {
        if (!v.I(this.erh)) {
            int size = this.erg.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.erg.get(size) == null || !this.erg.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.erg.remove(size);
                        this.erg.add(this.erh.remove(0));
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

    private boolean cf(List<MFollowResult> list) {
        if (v.I(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.erg.iterator();
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
    public boolean cg(List<MetaData> list) {
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
    public boolean aKq() {
        return this.Td != null && this.Td.isShowing();
    }

    public void Td() {
        if (aKq()) {
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
        if (id == e.g.btn_attention_all && this.eqU != null) {
            this.eqU.cd(aKo());
        }
    }
}
