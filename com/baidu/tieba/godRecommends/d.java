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
import com.baidu.tbadk.core.util.ak;
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
    private com.baidu.tbadk.core.dialog.a JV;
    private TbPageContext<?> adf;
    private View aze;
    private TextView dyA;
    private View dyB;
    private TextView dyC;
    private a dyr;
    private ViewGroup dyw;
    private com.baidu.tieba.godRecommends.a dyx;
    private TextView dyy;
    private View dyz;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> dyD = new ArrayList();
    private List<MetaData> dyE = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.awE()) {
                if (!d.this.bB(d.this.dyD)) {
                    d.this.dyx.setData(d.this.dyD);
                } else {
                    d.this.Vl();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void by(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.dyr = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.w(cVar.awB())) {
            Vl();
            this.dyD.clear();
            this.dyE.clear();
            List<MetaData> awB = cVar.awB();
            int size = awB.size();
            if (size <= 3) {
                this.dyD.addAll(awB);
            } else {
                this.dyD.addAll(awB.subList(0, 3));
                this.dyE.addAll(awB.subList(3, size));
            }
            initUI();
            this.dyy.setText(d.k.god_recommend_title);
            ak.i(this.dyw, d.f.bg_god_recommend_layout);
            ak.h(this.dyy, d.C0126d.cp_cont_d);
            ak.j(this.aze, d.C0126d.cp_bg_line_b);
            ak.j(this.dyz, d.C0126d.cp_bg_line_a);
            ak.h(this.dyA, d.C0126d.cp_cont_f);
            ak.i(this.dyA, d.f.god_recommend_left_button_selector);
            ak.j(this.dyB, d.C0126d.cp_bg_line_a);
            ak.h(this.dyC, d.C0126d.cp_link_tip_a);
            ak.i(this.dyC, d.f.god_recommend_right_button_selertor);
            this.dyx.setData(this.dyD);
            this.mListView.setAdapter((ListAdapter) this.dyx);
            this.JV.reset();
            this.JV.b(this.adf).tD();
        }
    }

    private void initUI() {
        if (this.dyw == null) {
            this.dyw = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.god_recommend_content_layout, (ViewGroup) null);
            this.dyy = (TextView) this.dyw.findViewById(d.g.god_title);
            this.aze = this.dyw.findViewById(d.g.top_line);
            this.dyz = this.dyw.findViewById(d.g.content_button_divider);
            this.dyA = (TextView) this.dyw.findViewById(d.g.btn_to_do_leter);
            this.dyA.setOnClickListener(this);
            this.dyB = this.dyw.findViewById(d.g.button_divider);
            this.dyC = (TextView) this.dyw.findViewById(d.g.btn_attention_all);
            this.dyC.setOnClickListener(this);
            this.mListView = (ListView) this.dyw.findViewById(d.g.listview);
            this.dyx = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dyx.setOnClickListener(this.mOnClickListener);
        }
        if (this.JV == null) {
            this.JV = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.JV.w(this.dyw);
            this.JV.cb(1);
            this.JV.as(true);
        }
    }

    private List<MetaData> awC() {
        if (v.w(this.dyD)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dyD) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData lP(int i) {
        return this.dyx.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!v.w(list) && awE()) {
            boolean bA = bA(list);
            if (z) {
                if (bA) {
                    l.showToast(this.mActivity, d.k.attention_success);
                    Vl();
                    return;
                }
                this.dyx.setData(this.dyD);
                l.showToast(this.mActivity, d.k.attention_fail);
            } else if (bA) {
                this.dyx.setData(this.dyD);
                awD();
            } else {
                l.showToast(this.mActivity, bz(list));
            }
        }
    }

    private String bz(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.w(list)) {
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

    private void awD() {
        if (!v.w(this.dyE)) {
            int size = this.dyD.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dyD.get(size) == null || !this.dyD.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dyD.remove(size);
                        this.dyD.add(this.dyE.remove(0));
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

    private boolean bA(List<MFollowResult> list) {
        if (v.w(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dyD.iterator();
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
    public boolean bB(List<MetaData> list) {
        if (!v.w(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awE() {
        return this.JV != null && this.JV.isShowing();
    }

    public void Vl() {
        if (awE()) {
            this.JV.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == d.g.btn_to_do_leter) {
            this.JV.dismiss();
        }
        if (id == d.g.btn_attention_all && this.dyr != null) {
            this.dyr.by(awC());
        }
    }
}
