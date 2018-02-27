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
    private TbPageContext<?> aRG;
    private com.baidu.tbadk.core.dialog.a axJ;
    private View boC;
    private ViewGroup edA;
    private com.baidu.tieba.godRecommends.a edB;
    private TextView edC;
    private View edD;
    private TextView edE;
    private View edF;
    private TextView edG;
    private a edv;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> edH = new ArrayList();
    private List<MetaData> edI = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aBH()) {
                if (!d.this.bH(d.this.edH)) {
                    d.this.edB.setData(d.this.edH);
                } else {
                    d.this.abj();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bE(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aRG = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.edv = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.E(cVar.aBE())) {
            abj();
            this.edH.clear();
            this.edI.clear();
            List<MetaData> aBE = cVar.aBE();
            int size = aBE.size();
            if (size <= 3) {
                this.edH.addAll(aBE);
            } else {
                this.edH.addAll(aBE.subList(0, 3));
                this.edI.addAll(aBE.subList(3, size));
            }
            initUI();
            this.edC.setText(d.j.god_recommend_title);
            aj.s(this.edA, d.f.bg_god_recommend_layout);
            aj.r(this.edC, d.C0141d.cp_cont_d);
            aj.t(this.boC, d.C0141d.cp_bg_line_b);
            aj.t(this.edD, d.C0141d.cp_bg_line_a);
            aj.r(this.edE, d.C0141d.cp_cont_f);
            aj.s(this.edE, d.f.god_recommend_left_button_selector);
            aj.t(this.edF, d.C0141d.cp_bg_line_a);
            aj.r(this.edG, d.C0141d.cp_link_tip_a);
            aj.s(this.edG, d.f.god_recommend_right_button_selertor);
            this.edB.setData(this.edH);
            this.mListView.setAdapter((ListAdapter) this.edB);
            this.axJ.reset();
            this.axJ.b(this.aRG).AU();
        }
    }

    private void initUI() {
        if (this.edA == null) {
            this.edA = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.edC = (TextView) this.edA.findViewById(d.g.god_title);
            this.boC = this.edA.findViewById(d.g.top_line);
            this.edD = this.edA.findViewById(d.g.content_button_divider);
            this.edE = (TextView) this.edA.findViewById(d.g.btn_to_do_leter);
            this.edE.setOnClickListener(this);
            this.edF = this.edA.findViewById(d.g.button_divider);
            this.edG = (TextView) this.edA.findViewById(d.g.btn_attention_all);
            this.edG.setOnClickListener(this);
            this.mListView = (ListView) this.edA.findViewById(d.g.listview);
            this.edB = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.edB.setOnClickListener(this.mOnClickListener);
        }
        if (this.axJ == null) {
            this.axJ = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.axJ.aO(this.edA);
            this.axJ.fd(1);
            this.axJ.ba(true);
        }
    }

    private List<MetaData> aBF() {
        if (v.E(this.edH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.edH) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData op(int i) {
        return this.edB.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.E(list) && aBH()) {
            boolean bG = bG(list);
            if (z) {
                if (bG) {
                    l.showToast(this.mActivity, d.j.attention_success);
                    abj();
                    return;
                }
                this.edB.setData(this.edH);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (bG) {
                this.edB.setData(this.edH);
                aBG();
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

    private void aBG() {
        if (!v.E(this.edI)) {
            int size = this.edH.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.edH.get(size) == null || !this.edH.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.edH.remove(size);
                        this.edH.add(this.edI.remove(0));
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
                Iterator<MetaData> it = this.edH.iterator();
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
    public boolean aBH() {
        return this.axJ != null && this.axJ.isShowing();
    }

    public void abj() {
        if (aBH()) {
            this.axJ.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.axJ.dismiss();
        }
        if (id == d.g.btn_attention_all && this.edv != null) {
            this.edv.bE(aBF());
        }
    }
}
