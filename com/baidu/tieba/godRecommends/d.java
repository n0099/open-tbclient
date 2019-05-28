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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a TF;
    private a fUL;
    private ViewGroup fUQ;
    private com.baidu.tieba.godRecommends.a fUR;
    private TextView fUS;
    private View fUT;
    private TextView fUU;
    private View fUV;
    private TextView fUW;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fUX = new ArrayList();
    private List<MetaData> fUY = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bsn()) {
                if (!d.this.cw(d.this.fUX)) {
                    d.this.fUR.setData(d.this.fUX);
                } else {
                    d.this.ayB();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void ct(List<MetaData> list);
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
        this.fUL = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.bsk())) {
            ayB();
            this.fUX.clear();
            this.fUY.clear();
            List<MetaData> bsk = cVar.bsk();
            int size = bsk.size();
            if (size <= 3) {
                this.fUX.addAll(bsk);
            } else {
                this.fUX.addAll(bsk.subList(0, 3));
                this.fUY.addAll(bsk.subList(3, size));
            }
            initUI();
            this.fUS.setText(R.string.god_recommend_title);
            al.k(this.fUQ, R.drawable.bg_god_recommend_layout);
            al.j(this.fUS, R.color.cp_cont_d);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.fUT, R.color.cp_bg_line_a);
            al.j(this.fUU, R.color.cp_cont_f);
            al.k(this.fUU, R.drawable.god_recommend_left_button_selector);
            al.l(this.fUV, R.color.cp_bg_line_a);
            al.j(this.fUW, R.color.cp_link_tip_a);
            al.k(this.fUW, R.drawable.god_recommend_right_button_selertor);
            this.fUR.setData(this.fUX);
            this.mListView.setAdapter((ListAdapter) this.fUR);
            this.TF.reset();
            this.TF.b(this.mContext).afG();
        }
    }

    private void initUI() {
        if (this.fUQ == null) {
            this.fUQ = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.fUS = (TextView) this.fUQ.findViewById(R.id.god_title);
            this.mTopLine = this.fUQ.findViewById(R.id.top_line);
            this.fUT = this.fUQ.findViewById(R.id.content_button_divider);
            this.fUU = (TextView) this.fUQ.findViewById(R.id.btn_to_do_leter);
            this.fUU.setOnClickListener(this);
            this.fUV = this.fUQ.findViewById(R.id.button_divider);
            this.fUW = (TextView) this.fUQ.findViewById(R.id.btn_attention_all);
            this.fUW.setOnClickListener(this);
            this.mListView = (ListView) this.fUQ.findViewById(R.id.listview);
            this.fUR = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fUR.setOnClickListener(this.mOnClickListener);
        }
        if (this.TF == null) {
            this.TF = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TF.aF(this.fUQ);
            this.TF.hr(1);
            this.TF.dN(true);
        }
    }

    private List<MetaData> bsl() {
        if (v.aa(this.fUX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fUX) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ti(int i) {
        return this.fUR.getItem(i);
    }

    public void m(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && bsn()) {
            boolean cv = cv(list);
            if (z) {
                if (cv) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    ayB();
                    return;
                }
                this.fUR.setData(this.fUX);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cv) {
                this.fUR.setData(this.fUX);
                bsm();
            } else {
                l.showToast(this.mActivity, cu(list));
            }
        }
    }

    private String cu(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.aa(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(R.string.attention_fail) : str;
    }

    private void bsm() {
        if (!v.aa(this.fUY)) {
            int size = this.fUX.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fUX.get(size) == null || !this.fUX.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fUX.remove(size);
                        this.fUX.add(this.fUY.remove(0));
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

    private boolean cv(List<MFollowResult> list) {
        if (v.aa(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.fUX.iterator();
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
    public boolean cw(List<MetaData> list) {
        if (!v.aa(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsn() {
        return this.TF != null && this.TF.isShowing();
    }

    public void ayB() {
        if (bsn()) {
            this.TF.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.TF.dismiss();
        }
        if (id == R.id.btn_attention_all && this.fUL != null) {
            this.fUL.ct(bsl());
        }
    }
}
