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
import com.baidu.tbadk.core.util.am;
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
    private com.baidu.tbadk.core.dialog.a Qj;
    private View aIx;
    private a dQJ;
    private ViewGroup dQO;
    private com.baidu.tieba.godRecommends.a dQP;
    private TextView dQQ;
    private View dQR;
    private TextView dQS;
    private View dQT;
    private TextView dQU;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> dQV = new ArrayList();
    private List<MetaData> dQW = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aCK()) {
                if (!d.this.bM(d.this.dQV)) {
                    d.this.dQP.setData(d.this.dQV);
                } else {
                    d.this.ZB();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bJ(List<MetaData> list);
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
        this.dQJ = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !w.z(cVar.aCH())) {
            ZB();
            this.dQV.clear();
            this.dQW.clear();
            List<MetaData> aCH = cVar.aCH();
            int size = aCH.size();
            if (size <= 3) {
                this.dQV.addAll(aCH);
            } else {
                this.dQV.addAll(aCH.subList(0, 3));
                this.dQW.addAll(aCH.subList(3, size));
            }
            initUI();
            this.dQQ.setText(d.j.god_recommend_title);
            am.i(this.dQO, d.f.bg_god_recommend_layout);
            am.h(this.dQQ, d.C0140d.cp_cont_d);
            am.j(this.aIx, d.C0140d.cp_bg_line_b);
            am.j(this.dQR, d.C0140d.cp_bg_line_a);
            am.h(this.dQS, d.C0140d.cp_cont_f);
            am.i(this.dQS, d.f.god_recommend_left_button_selector);
            am.j(this.dQT, d.C0140d.cp_bg_line_a);
            am.h(this.dQU, d.C0140d.cp_link_tip_a);
            am.i(this.dQU, d.f.god_recommend_right_button_selertor);
            this.dQP.setData(this.dQV);
            this.mListView.setAdapter((ListAdapter) this.dQP);
            this.Qj.reset();
            this.Qj.b(this.mContext).xf();
        }
    }

    private void initUI() {
        if (this.dQO == null) {
            this.dQO = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.dQQ = (TextView) this.dQO.findViewById(d.g.god_title);
            this.aIx = this.dQO.findViewById(d.g.top_line);
            this.dQR = this.dQO.findViewById(d.g.content_button_divider);
            this.dQS = (TextView) this.dQO.findViewById(d.g.btn_to_do_leter);
            this.dQS.setOnClickListener(this);
            this.dQT = this.dQO.findViewById(d.g.button_divider);
            this.dQU = (TextView) this.dQO.findViewById(d.g.btn_attention_all);
            this.dQU.setOnClickListener(this);
            this.mListView = (ListView) this.dQO.findViewById(d.g.listview);
            this.dQP = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dQP.setOnClickListener(this.mOnClickListener);
        }
        if (this.Qj == null) {
            this.Qj = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Qj.w(this.dQO);
            this.Qj.ch(1);
            this.Qj.av(true);
        }
    }

    private List<MetaData> aCI() {
        if (w.z(this.dQV)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dQV) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData mt(int i) {
        return this.dQP.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!w.z(list) && aCK()) {
            boolean bL = bL(list);
            if (z) {
                if (bL) {
                    l.showToast(this.mActivity, d.j.attention_success);
                    ZB();
                    return;
                }
                this.dQP.setData(this.dQV);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (bL) {
                this.dQP.setData(this.dQV);
                aCJ();
            } else {
                l.showToast(this.mActivity, bK(list));
            }
        }
    }

    private String bK(List<MFollowResult> list) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(d.j.attention_fail) : str;
    }

    private void aCJ() {
        if (!w.z(this.dQW)) {
            int size = this.dQV.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dQV.get(size) == null || !this.dQV.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dQV.remove(size);
                        this.dQV.add(this.dQW.remove(0));
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

    private boolean bL(List<MFollowResult> list) {
        if (w.z(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dQV.iterator();
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
    public boolean bM(List<MetaData> list) {
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
    public boolean aCK() {
        return this.Qj != null && this.Qj.isShowing();
    }

    public void ZB() {
        if (aCK()) {
            this.Qj.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.Qj.dismiss();
        }
        if (id == d.g.btn_attention_all && this.dQJ != null) {
            this.dQJ.bJ(aCI());
        }
    }
}
