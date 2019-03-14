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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a VQ;
    private a fDZ;
    private ViewGroup fEe;
    private com.baidu.tieba.godRecommends.a fEf;
    private TextView fEg;
    private View fEh;
    private TextView fEi;
    private View fEj;
    private TextView fEk;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fEl = new ArrayList();
    private List<MetaData> fEm = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bkV()) {
                if (!d.this.cr(d.this.fEl)) {
                    d.this.fEf.setData(d.this.fEl);
                } else {
                    d.this.aty();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void co(List<MetaData> list);
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
        this.fDZ = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.T(cVar.bkS())) {
            aty();
            this.fEl.clear();
            this.fEm.clear();
            List<MetaData> bkS = cVar.bkS();
            int size = bkS.size();
            if (size <= 3) {
                this.fEl.addAll(bkS);
            } else {
                this.fEl.addAll(bkS.subList(0, 3));
                this.fEm.addAll(bkS.subList(3, size));
            }
            initUI();
            this.fEg.setText(d.j.god_recommend_title);
            al.k(this.fEe, d.f.bg_god_recommend_layout);
            al.j(this.fEg, d.C0277d.cp_cont_d);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
            al.l(this.fEh, d.C0277d.cp_bg_line_a);
            al.j(this.fEi, d.C0277d.cp_cont_f);
            al.k(this.fEi, d.f.god_recommend_left_button_selector);
            al.l(this.fEj, d.C0277d.cp_bg_line_a);
            al.j(this.fEk, d.C0277d.cp_link_tip_a);
            al.k(this.fEk, d.f.god_recommend_right_button_selertor);
            this.fEf.setData(this.fEl);
            this.mListView.setAdapter((ListAdapter) this.fEf);
            this.VQ.reset();
            this.VQ.b(this.mContext).aaZ();
        }
    }

    private void initUI() {
        if (this.fEe == null) {
            this.fEe = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.fEg = (TextView) this.fEe.findViewById(d.g.god_title);
            this.mTopLine = this.fEe.findViewById(d.g.top_line);
            this.fEh = this.fEe.findViewById(d.g.content_button_divider);
            this.fEi = (TextView) this.fEe.findViewById(d.g.btn_to_do_leter);
            this.fEi.setOnClickListener(this);
            this.fEj = this.fEe.findViewById(d.g.button_divider);
            this.fEk = (TextView) this.fEe.findViewById(d.g.btn_attention_all);
            this.fEk.setOnClickListener(this);
            this.mListView = (ListView) this.fEe.findViewById(d.g.listview);
            this.fEf = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fEf.setOnClickListener(this.mOnClickListener);
        }
        if (this.VQ == null) {
            this.VQ = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.VQ.az(this.fEe);
            this.VQ.gF(1);
            this.VQ.dr(true);
        }
    }

    private List<MetaData> bkT() {
        if (v.T(this.fEl)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fEl) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData se(int i) {
        return this.fEf.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.T(list) && bkV()) {
            boolean cq = cq(list);
            if (z) {
                if (cq) {
                    l.showToast(this.mActivity, d.j.attention_success);
                    aty();
                    return;
                }
                this.fEf.setData(this.fEl);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (cq) {
                this.fEf.setData(this.fEl);
                bkU();
            } else {
                l.showToast(this.mActivity, cp(list));
            }
        }
    }

    private String cp(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.T(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(d.j.attention_fail) : str;
    }

    private void bkU() {
        if (!v.T(this.fEm)) {
            int size = this.fEl.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fEl.get(size) == null || !this.fEl.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fEl.remove(size);
                        this.fEl.add(this.fEm.remove(0));
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

    private boolean cq(List<MFollowResult> list) {
        if (v.T(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.fEl.iterator();
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
    public boolean cr(List<MetaData> list) {
        if (!v.T(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkV() {
        return this.VQ != null && this.VQ.isShowing();
    }

    public void aty() {
        if (bkV()) {
            this.VQ.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.VQ.dismiss();
        }
        if (id == d.g.btn_attention_all && this.fDZ != null) {
            this.fDZ.co(bkT());
        }
    }
}
