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
    private com.baidu.tbadk.core.dialog.a TD;
    private a fUN;
    private ViewGroup fUS;
    private com.baidu.tieba.godRecommends.a fUT;
    private TextView fUU;
    private View fUV;
    private TextView fUW;
    private View fUX;
    private TextView fUY;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fUZ = new ArrayList();
    private List<MetaData> fVa = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bsp()) {
                if (!d.this.cw(d.this.fUZ)) {
                    d.this.fUT.setData(d.this.fUZ);
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
        this.fUN = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.bsm())) {
            ayB();
            this.fUZ.clear();
            this.fVa.clear();
            List<MetaData> bsm = cVar.bsm();
            int size = bsm.size();
            if (size <= 3) {
                this.fUZ.addAll(bsm);
            } else {
                this.fUZ.addAll(bsm.subList(0, 3));
                this.fVa.addAll(bsm.subList(3, size));
            }
            initUI();
            this.fUU.setText(R.string.god_recommend_title);
            al.k(this.fUS, R.drawable.bg_god_recommend_layout);
            al.j(this.fUU, R.color.cp_cont_d);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.fUV, R.color.cp_bg_line_a);
            al.j(this.fUW, R.color.cp_cont_f);
            al.k(this.fUW, R.drawable.god_recommend_left_button_selector);
            al.l(this.fUX, R.color.cp_bg_line_a);
            al.j(this.fUY, R.color.cp_link_tip_a);
            al.k(this.fUY, R.drawable.god_recommend_right_button_selertor);
            this.fUT.setData(this.fUZ);
            this.mListView.setAdapter((ListAdapter) this.fUT);
            this.TD.reset();
            this.TD.b(this.mContext).afG();
        }
    }

    private void initUI() {
        if (this.fUS == null) {
            this.fUS = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.fUU = (TextView) this.fUS.findViewById(R.id.god_title);
            this.mTopLine = this.fUS.findViewById(R.id.top_line);
            this.fUV = this.fUS.findViewById(R.id.content_button_divider);
            this.fUW = (TextView) this.fUS.findViewById(R.id.btn_to_do_leter);
            this.fUW.setOnClickListener(this);
            this.fUX = this.fUS.findViewById(R.id.button_divider);
            this.fUY = (TextView) this.fUS.findViewById(R.id.btn_attention_all);
            this.fUY.setOnClickListener(this);
            this.mListView = (ListView) this.fUS.findViewById(R.id.listview);
            this.fUT = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fUT.setOnClickListener(this.mOnClickListener);
        }
        if (this.TD == null) {
            this.TD = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TD.aF(this.fUS);
            this.TD.hr(1);
            this.TD.dN(true);
        }
    }

    private List<MetaData> bsn() {
        if (v.aa(this.fUZ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fUZ) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ti(int i) {
        return this.fUT.getItem(i);
    }

    public void m(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && bsp()) {
            boolean cv = cv(list);
            if (z) {
                if (cv) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    ayB();
                    return;
                }
                this.fUT.setData(this.fUZ);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cv) {
                this.fUT.setData(this.fUZ);
                bso();
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

    private void bso() {
        if (!v.aa(this.fVa)) {
            int size = this.fUZ.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fUZ.get(size) == null || !this.fUZ.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fUZ.remove(size);
                        this.fUZ.add(this.fVa.remove(0));
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
                Iterator<MetaData> it = this.fUZ.iterator();
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
    public boolean bsp() {
        return this.TD != null && this.TD.isShowing();
    }

    public void ayB() {
        if (bsp()) {
            this.TD.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.TD.dismiss();
        }
        if (id == R.id.btn_attention_all && this.fUN != null) {
            this.fUN.ct(bsn());
        }
    }
}
