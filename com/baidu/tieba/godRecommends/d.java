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
    private com.baidu.tbadk.core.dialog.a Tm;
    private a erB;
    private ViewGroup erG;
    private com.baidu.tieba.godRecommends.a erH;
    private TextView erI;
    private View erJ;
    private TextView erK;
    private View erL;
    private TextView erM;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> erN = new ArrayList();
    private List<MetaData> erO = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aKO()) {
                if (!d.this.ch(d.this.erN)) {
                    d.this.erH.setData(d.this.erN);
                } else {
                    d.this.Tz();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void ce(List<MetaData> list);
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
        this.erB = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.I(cVar.aKL())) {
            Tz();
            this.erN.clear();
            this.erO.clear();
            List<MetaData> aKL = cVar.aKL();
            int size = aKL.size();
            if (size <= 3) {
                this.erN.addAll(aKL);
            } else {
                this.erN.addAll(aKL.subList(0, 3));
                this.erO.addAll(aKL.subList(3, size));
            }
            initUI();
            this.erI.setText(e.j.god_recommend_title);
            al.i(this.erG, e.f.bg_god_recommend_layout);
            al.h(this.erI, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.erJ, e.d.cp_bg_line_a);
            al.h(this.erK, e.d.cp_cont_f);
            al.i(this.erK, e.f.god_recommend_left_button_selector);
            al.j(this.erL, e.d.cp_bg_line_a);
            al.h(this.erM, e.d.cp_link_tip_a);
            al.i(this.erM, e.f.god_recommend_right_button_selertor);
            this.erH.setData(this.erN);
            this.mListView.setAdapter((ListAdapter) this.erH);
            this.Tm.reset();
            this.Tm.b(this.mContext).BS();
        }
    }

    private void initUI() {
        if (this.erG == null) {
            this.erG = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.erI = (TextView) this.erG.findViewById(e.g.god_title);
            this.mTopLine = this.erG.findViewById(e.g.top_line);
            this.erJ = this.erG.findViewById(e.g.content_button_divider);
            this.erK = (TextView) this.erG.findViewById(e.g.btn_to_do_leter);
            this.erK.setOnClickListener(this);
            this.erL = this.erG.findViewById(e.g.button_divider);
            this.erM = (TextView) this.erG.findViewById(e.g.btn_attention_all);
            this.erM.setOnClickListener(this);
            this.mListView = (ListView) this.erG.findViewById(e.g.listview);
            this.erH = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.erH.setOnClickListener(this.mOnClickListener);
        }
        if (this.Tm == null) {
            this.Tm = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Tm.G(this.erG);
            this.Tm.dd(1);
            this.Tm.bh(true);
        }
    }

    private List<MetaData> aKM() {
        if (v.I(this.erN)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.erN) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ov(int i) {
        return this.erH.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.I(list) && aKO()) {
            boolean cg = cg(list);
            if (z) {
                if (cg) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    Tz();
                    return;
                }
                this.erH.setData(this.erN);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (cg) {
                this.erH.setData(this.erN);
                aKN();
            } else {
                l.showToast(this.mActivity, cf(list));
            }
        }
    }

    private String cf(List<MFollowResult> list) {
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

    private void aKN() {
        if (!v.I(this.erO)) {
            int size = this.erN.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.erN.get(size) == null || !this.erN.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.erN.remove(size);
                        this.erN.add(this.erO.remove(0));
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

    private boolean cg(List<MFollowResult> list) {
        if (v.I(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.erN.iterator();
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
    public boolean ch(List<MetaData> list) {
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
    public boolean aKO() {
        return this.Tm != null && this.Tm.isShowing();
    }

    public void Tz() {
        if (aKO()) {
            this.Tm.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.btn_to_do_leter) {
            this.Tm.dismiss();
        }
        if (id == e.g.btn_attention_all && this.erB != null) {
            this.erB.ce(aKM());
        }
    }
}
