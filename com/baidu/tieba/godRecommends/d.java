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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a Qk;
    private View aHA;
    private a dKF;
    private ViewGroup dKK;
    private com.baidu.tieba.godRecommends.a dKL;
    private TextView dKM;
    private View dKN;
    private TextView dKO;
    private View dKP;
    private TextView dKQ;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> dKR = new ArrayList();
    private List<MetaData> dKS = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aBv()) {
                if (!d.this.bJ(d.this.dKR)) {
                    d.this.dKL.setData(d.this.dKR);
                } else {
                    d.this.YO();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bG(List<MetaData> list);
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
        this.dKF = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !w.z(cVar.aBs())) {
            YO();
            this.dKR.clear();
            this.dKS.clear();
            List<MetaData> aBs = cVar.aBs();
            int size = aBs.size();
            if (size <= 3) {
                this.dKR.addAll(aBs);
            } else {
                this.dKR.addAll(aBs.subList(0, 3));
                this.dKS.addAll(aBs.subList(3, size));
            }
            initUI();
            this.dKM.setText(d.k.god_recommend_title);
            al.i(this.dKK, d.f.bg_god_recommend_layout);
            al.h(this.dKM, d.C0141d.cp_cont_d);
            al.j(this.aHA, d.C0141d.cp_bg_line_b);
            al.j(this.dKN, d.C0141d.cp_bg_line_a);
            al.h(this.dKO, d.C0141d.cp_cont_f);
            al.i(this.dKO, d.f.god_recommend_left_button_selector);
            al.j(this.dKP, d.C0141d.cp_bg_line_a);
            al.h(this.dKQ, d.C0141d.cp_link_tip_a);
            al.i(this.dKQ, d.f.god_recommend_right_button_selertor);
            this.dKL.setData(this.dKR);
            this.mListView.setAdapter((ListAdapter) this.dKL);
            this.Qk.reset();
            this.Qk.b(this.mContext).xa();
        }
    }

    private void initUI() {
        if (this.dKK == null) {
            this.dKK = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.god_recommend_content_layout, (ViewGroup) null);
            this.dKM = (TextView) this.dKK.findViewById(d.g.god_title);
            this.aHA = this.dKK.findViewById(d.g.top_line);
            this.dKN = this.dKK.findViewById(d.g.content_button_divider);
            this.dKO = (TextView) this.dKK.findViewById(d.g.btn_to_do_leter);
            this.dKO.setOnClickListener(this);
            this.dKP = this.dKK.findViewById(d.g.button_divider);
            this.dKQ = (TextView) this.dKK.findViewById(d.g.btn_attention_all);
            this.dKQ.setOnClickListener(this);
            this.mListView = (ListView) this.dKK.findViewById(d.g.listview);
            this.dKL = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dKL.setOnClickListener(this.mOnClickListener);
        }
        if (this.Qk == null) {
            this.Qk = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Qk.w(this.dKK);
            this.Qk.ce(1);
            this.Qk.av(true);
        }
    }

    private List<MetaData> aBt() {
        if (w.z(this.dKR)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dKR) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData ma(int i) {
        return this.dKL.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!w.z(list) && aBv()) {
            boolean bI = bI(list);
            if (z) {
                if (bI) {
                    l.showToast(this.mActivity, d.k.attention_success);
                    YO();
                    return;
                }
                this.dKL.setData(this.dKR);
                l.showToast(this.mActivity, d.k.attention_fail);
            } else if (bI) {
                this.dKL.setData(this.dKR);
                aBu();
            } else {
                l.showToast(this.mActivity, bH(list));
            }
        }
    }

    private String bH(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (w.z(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(d.k.attention_fail) : str;
    }

    private void aBu() {
        if (!w.z(this.dKS)) {
            int size = this.dKR.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dKR.get(size) == null || !this.dKR.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dKR.remove(size);
                        this.dKR.add(this.dKS.remove(0));
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

    private boolean bI(List<MFollowResult> list) {
        if (w.z(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dKR.iterator();
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
    public boolean bJ(List<MetaData> list) {
        if (!w.z(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBv() {
        return this.Qk != null && this.Qk.isShowing();
    }

    public void YO() {
        if (aBv()) {
            this.Qk.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.Qk.dismiss();
        }
        if (id == d.g.btn_attention_all && this.dKF != null) {
            this.dKF.bG(aBt());
        }
    }
}
