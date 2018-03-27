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
    private TbPageContext<?> aRI;
    private com.baidu.tbadk.core.dialog.a axK;
    private View boF;
    private a edL;
    private ViewGroup edQ;
    private com.baidu.tieba.godRecommends.a edR;
    private TextView edS;
    private View edT;
    private TextView edU;
    private View edV;
    private TextView edW;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> edX = new ArrayList();
    private List<MetaData> edY = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aBI()) {
                if (!d.this.bH(d.this.edX)) {
                    d.this.edR.setData(d.this.edX);
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
        this.aRI = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.edL = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.E(cVar.aBF())) {
            abk();
            this.edX.clear();
            this.edY.clear();
            List<MetaData> aBF = cVar.aBF();
            int size = aBF.size();
            if (size <= 3) {
                this.edX.addAll(aBF);
            } else {
                this.edX.addAll(aBF.subList(0, 3));
                this.edY.addAll(aBF.subList(3, size));
            }
            initUI();
            this.edS.setText(d.j.god_recommend_title);
            aj.s(this.edQ, d.f.bg_god_recommend_layout);
            aj.r(this.edS, d.C0141d.cp_cont_d);
            aj.t(this.boF, d.C0141d.cp_bg_line_b);
            aj.t(this.edT, d.C0141d.cp_bg_line_a);
            aj.r(this.edU, d.C0141d.cp_cont_f);
            aj.s(this.edU, d.f.god_recommend_left_button_selector);
            aj.t(this.edV, d.C0141d.cp_bg_line_a);
            aj.r(this.edW, d.C0141d.cp_link_tip_a);
            aj.s(this.edW, d.f.god_recommend_right_button_selertor);
            this.edR.setData(this.edX);
            this.mListView.setAdapter((ListAdapter) this.edR);
            this.axK.reset();
            this.axK.b(this.aRI).AV();
        }
    }

    private void initUI() {
        if (this.edQ == null) {
            this.edQ = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.edS = (TextView) this.edQ.findViewById(d.g.god_title);
            this.boF = this.edQ.findViewById(d.g.top_line);
            this.edT = this.edQ.findViewById(d.g.content_button_divider);
            this.edU = (TextView) this.edQ.findViewById(d.g.btn_to_do_leter);
            this.edU.setOnClickListener(this);
            this.edV = this.edQ.findViewById(d.g.button_divider);
            this.edW = (TextView) this.edQ.findViewById(d.g.btn_attention_all);
            this.edW.setOnClickListener(this);
            this.mListView = (ListView) this.edQ.findViewById(d.g.listview);
            this.edR = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.edR.setOnClickListener(this.mOnClickListener);
        }
        if (this.axK == null) {
            this.axK = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.axK.aO(this.edQ);
            this.axK.fd(1);
            this.axK.ba(true);
        }
    }

    private List<MetaData> aBG() {
        if (v.E(this.edX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.edX) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData oq(int i) {
        return this.edR.getItem(i);
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
                this.edR.setData(this.edX);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (bG) {
                this.edR.setData(this.edX);
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
        if (!v.E(this.edY)) {
            int size = this.edX.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.edX.get(size) == null || !this.edX.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.edX.remove(size);
                        this.edX.add(this.edY.remove(0));
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
                Iterator<MetaData> it = this.edX.iterator();
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
        return this.axK != null && this.axK.isShowing();
    }

    public void abk() {
        if (aBI()) {
            this.axK.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.axK.dismiss();
        }
        if (id == d.g.btn_attention_all && this.edL != null) {
            this.edL.bE(aBG());
        }
    }
}
