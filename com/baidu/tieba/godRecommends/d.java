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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a Tb;
    private a efQ;
    private ViewGroup efV;
    private com.baidu.tieba.godRecommends.a efW;
    private TextView efX;
    private View efY;
    private TextView efZ;
    private View ega;
    private TextView egb;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> egc = new ArrayList();
    private List<MetaData> egd = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aIm()) {
                if (!d.this.cd(d.this.egc)) {
                    d.this.efW.setData(d.this.egc);
                } else {
                    d.this.RM();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void ca(List<MetaData> list);
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
        this.efQ = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.J(cVar.aIj())) {
            RM();
            this.egc.clear();
            this.egd.clear();
            List<MetaData> aIj = cVar.aIj();
            int size = aIj.size();
            if (size <= 3) {
                this.egc.addAll(aIj);
            } else {
                this.egc.addAll(aIj.subList(0, 3));
                this.egd.addAll(aIj.subList(3, size));
            }
            initUI();
            this.efX.setText(e.j.god_recommend_title);
            al.i(this.efV, e.f.bg_god_recommend_layout);
            al.h(this.efX, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.efY, e.d.cp_bg_line_a);
            al.h(this.efZ, e.d.cp_cont_f);
            al.i(this.efZ, e.f.god_recommend_left_button_selector);
            al.j(this.ega, e.d.cp_bg_line_a);
            al.h(this.egb, e.d.cp_link_tip_a);
            al.i(this.egb, e.f.god_recommend_right_button_selertor);
            this.efW.setData(this.egc);
            this.mListView.setAdapter((ListAdapter) this.efW);
            this.Tb.reset();
            this.Tb.b(this.mContext).Au();
        }
    }

    private void initUI() {
        if (this.efV == null) {
            this.efV = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.efX = (TextView) this.efV.findViewById(e.g.god_title);
            this.mTopLine = this.efV.findViewById(e.g.top_line);
            this.efY = this.efV.findViewById(e.g.content_button_divider);
            this.efZ = (TextView) this.efV.findViewById(e.g.btn_to_do_leter);
            this.efZ.setOnClickListener(this);
            this.ega = this.efV.findViewById(e.g.button_divider);
            this.egb = (TextView) this.efV.findViewById(e.g.btn_attention_all);
            this.egb.setOnClickListener(this);
            this.mListView = (ListView) this.efV.findViewById(e.g.listview);
            this.efW = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.efW.setOnClickListener(this.mOnClickListener);
        }
        if (this.Tb == null) {
            this.Tb = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Tb.G(this.efV);
            this.Tb.cB(1);
            this.Tb.aP(true);
        }
    }

    private List<MetaData> aIk() {
        if (v.J(this.egc)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.egc) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData nv(int i) {
        return this.efW.getItem(i);
    }

    public void l(List<MFollowResult> list, boolean z) {
        if (!v.J(list) && aIm()) {
            boolean cc = cc(list);
            if (z) {
                if (cc) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    RM();
                    return;
                }
                this.efW.setData(this.egc);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (cc) {
                this.efW.setData(this.egc);
                aIl();
            } else {
                l.showToast(this.mActivity, cb(list));
            }
        }
    }

    private String cb(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.J(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(e.j.attention_fail) : str;
    }

    private void aIl() {
        if (!v.J(this.egd)) {
            int size = this.egc.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.egc.get(size) == null || !this.egc.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.egc.remove(size);
                        this.egc.add(this.egd.remove(0));
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

    private boolean cc(List<MFollowResult> list) {
        if (v.J(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.egc.iterator();
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
    public boolean cd(List<MetaData> list) {
        if (!v.J(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIm() {
        return this.Tb != null && this.Tb.isShowing();
    }

    public void RM() {
        if (aIm()) {
            this.Tb.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.btn_to_do_leter) {
            this.Tb.dismiss();
        }
        if (id == e.g.btn_attention_all && this.efQ != null) {
            this.efQ.ca(aIk());
        }
    }
}
