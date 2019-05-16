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
    private a fUK;
    private ViewGroup fUP;
    private com.baidu.tieba.godRecommends.a fUQ;
    private TextView fUR;
    private View fUS;
    private TextView fUT;
    private View fUU;
    private TextView fUV;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fUW = new ArrayList();
    private List<MetaData> fUX = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bsk()) {
                if (!d.this.cw(d.this.fUW)) {
                    d.this.fUQ.setData(d.this.fUW);
                } else {
                    d.this.ayA();
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
        this.fUK = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.bsh())) {
            ayA();
            this.fUW.clear();
            this.fUX.clear();
            List<MetaData> bsh = cVar.bsh();
            int size = bsh.size();
            if (size <= 3) {
                this.fUW.addAll(bsh);
            } else {
                this.fUW.addAll(bsh.subList(0, 3));
                this.fUX.addAll(bsh.subList(3, size));
            }
            initUI();
            this.fUR.setText(R.string.god_recommend_title);
            al.k(this.fUP, R.drawable.bg_god_recommend_layout);
            al.j(this.fUR, R.color.cp_cont_d);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.fUS, R.color.cp_bg_line_a);
            al.j(this.fUT, R.color.cp_cont_f);
            al.k(this.fUT, R.drawable.god_recommend_left_button_selector);
            al.l(this.fUU, R.color.cp_bg_line_a);
            al.j(this.fUV, R.color.cp_link_tip_a);
            al.k(this.fUV, R.drawable.god_recommend_right_button_selertor);
            this.fUQ.setData(this.fUW);
            this.mListView.setAdapter((ListAdapter) this.fUQ);
            this.TF.reset();
            this.TF.b(this.mContext).afG();
        }
    }

    private void initUI() {
        if (this.fUP == null) {
            this.fUP = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.fUR = (TextView) this.fUP.findViewById(R.id.god_title);
            this.mTopLine = this.fUP.findViewById(R.id.top_line);
            this.fUS = this.fUP.findViewById(R.id.content_button_divider);
            this.fUT = (TextView) this.fUP.findViewById(R.id.btn_to_do_leter);
            this.fUT.setOnClickListener(this);
            this.fUU = this.fUP.findViewById(R.id.button_divider);
            this.fUV = (TextView) this.fUP.findViewById(R.id.btn_attention_all);
            this.fUV.setOnClickListener(this);
            this.mListView = (ListView) this.fUP.findViewById(R.id.listview);
            this.fUQ = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fUQ.setOnClickListener(this.mOnClickListener);
        }
        if (this.TF == null) {
            this.TF = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TF.aF(this.fUP);
            this.TF.hr(1);
            this.TF.dN(true);
        }
    }

    private List<MetaData> bsi() {
        if (v.aa(this.fUW)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fUW) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ti(int i) {
        return this.fUQ.getItem(i);
    }

    public void m(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && bsk()) {
            boolean cv = cv(list);
            if (z) {
                if (cv) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    ayA();
                    return;
                }
                this.fUQ.setData(this.fUW);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cv) {
                this.fUQ.setData(this.fUW);
                bsj();
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

    private void bsj() {
        if (!v.aa(this.fUX)) {
            int size = this.fUW.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fUW.get(size) == null || !this.fUW.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fUW.remove(size);
                        this.fUW.add(this.fUX.remove(0));
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
                Iterator<MetaData> it = this.fUW.iterator();
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
    public boolean bsk() {
        return this.TF != null && this.TF.isShowing();
    }

    public void ayA() {
        if (bsk()) {
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
        if (id == R.id.btn_attention_all && this.fUK != null) {
            this.fUK.ct(bsi());
        }
    }
}
