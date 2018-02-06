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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private TbPageContext<?> aRR;
    private com.baidu.tbadk.core.dialog.a axS;
    private View boP;
    private a edH;
    private ViewGroup edM;
    private com.baidu.tieba.godRecommends.a edN;
    private TextView edO;
    private View edP;
    private TextView edQ;
    private View edR;
    private TextView edS;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> edT = new ArrayList();
    private List<MetaData> edU = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aBI()) {
                if (!d.this.bH(d.this.edT)) {
                    d.this.edN.setData(d.this.edT);
                } else {
                    d.this.abk();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bE(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aRR = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.edH = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.E(cVar.aBF())) {
            abk();
            this.edT.clear();
            this.edU.clear();
            List<MetaData> aBF = cVar.aBF();
            int size = aBF.size();
            if (size <= 3) {
                this.edT.addAll(aBF);
            } else {
                this.edT.addAll(aBF.subList(0, 3));
                this.edU.addAll(aBF.subList(3, size));
            }
            initUI();
            this.edO.setText(d.j.god_recommend_title);
            aj.s(this.edM, d.f.bg_god_recommend_layout);
            aj.r(this.edO, d.C0140d.cp_cont_d);
            aj.t(this.boP, d.C0140d.cp_bg_line_b);
            aj.t(this.edP, d.C0140d.cp_bg_line_a);
            aj.r(this.edQ, d.C0140d.cp_cont_f);
            aj.s(this.edQ, d.f.god_recommend_left_button_selector);
            aj.t(this.edR, d.C0140d.cp_bg_line_a);
            aj.r(this.edS, d.C0140d.cp_link_tip_a);
            aj.s(this.edS, d.f.god_recommend_right_button_selertor);
            this.edN.setData(this.edT);
            this.mListView.setAdapter((ListAdapter) this.edN);
            this.axS.reset();
            this.axS.b(this.aRR).AU();
        }
    }

    private void initUI() {
        if (this.edM == null) {
            this.edM = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.edO = (TextView) this.edM.findViewById(d.g.god_title);
            this.boP = this.edM.findViewById(d.g.top_line);
            this.edP = this.edM.findViewById(d.g.content_button_divider);
            this.edQ = (TextView) this.edM.findViewById(d.g.btn_to_do_leter);
            this.edQ.setOnClickListener(this);
            this.edR = this.edM.findViewById(d.g.button_divider);
            this.edS = (TextView) this.edM.findViewById(d.g.btn_attention_all);
            this.edS.setOnClickListener(this);
            this.mListView = (ListView) this.edM.findViewById(d.g.listview);
            this.edN = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.edN.setOnClickListener(this.mOnClickListener);
        }
        if (this.axS == null) {
            this.axS = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.axS.aO(this.edM);
            this.axS.fd(1);
            this.axS.ba(true);
        }
    }

    private List<MetaData> aBG() {
        if (v.E(this.edT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.edT) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData op(int i) {
        return this.edN.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.E(list) && aBI()) {
            boolean bG = bG(list);
            if (z) {
                if (bG) {
                    l.showToast(this.mActivity, d.j.attention_success);
                    abk();
                    return;
                }
                this.edN.setData(this.edT);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (bG) {
                this.edN.setData(this.edT);
                aBH();
            } else {
                l.showToast(this.mActivity, bF(list));
            }
        }
    }

    private String bF(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.E(list)) {
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

    private void aBH() {
        if (!v.E(this.edU)) {
            int size = this.edT.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.edT.get(size) == null || !this.edT.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.edT.remove(size);
                        this.edT.add(this.edU.remove(0));
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

    private boolean bG(List<MFollowResult> list) {
        if (v.E(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.edT.iterator();
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
    public boolean bH(List<MetaData> list) {
        if (!v.E(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBI() {
        return this.axS != null && this.axS.isShowing();
    }

    public void abk() {
        if (aBI()) {
            this.axS.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.axS.dismiss();
        }
        if (id == d.g.btn_attention_all && this.edH != null) {
            this.edH.bE(aBG());
        }
    }
}
