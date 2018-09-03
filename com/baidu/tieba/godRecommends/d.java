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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a Qj;
    private a dQE;
    private ViewGroup dQJ;
    private com.baidu.tieba.godRecommends.a dQK;
    private TextView dQL;
    private View dQM;
    private TextView dQN;
    private View dQO;
    private TextView dQP;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> dQQ = new ArrayList();
    private List<MetaData> dQR = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aCH()) {
                if (!d.this.bM(d.this.dQQ)) {
                    d.this.dQK.setData(d.this.dQQ);
                } else {
                    d.this.ZD();
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
        this.dQE = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !w.z(cVar.aCE())) {
            ZD();
            this.dQQ.clear();
            this.dQR.clear();
            List<MetaData> aCE = cVar.aCE();
            int size = aCE.size();
            if (size <= 3) {
                this.dQQ.addAll(aCE);
            } else {
                this.dQQ.addAll(aCE.subList(0, 3));
                this.dQR.addAll(aCE.subList(3, size));
            }
            initUI();
            this.dQL.setText(f.j.god_recommend_title);
            am.i(this.dQJ, f.C0146f.bg_god_recommend_layout);
            am.h(this.dQL, f.d.cp_cont_d);
            am.j(this.mTopLine, f.d.cp_bg_line_b);
            am.j(this.dQM, f.d.cp_bg_line_a);
            am.h(this.dQN, f.d.cp_cont_f);
            am.i(this.dQN, f.C0146f.god_recommend_left_button_selector);
            am.j(this.dQO, f.d.cp_bg_line_a);
            am.h(this.dQP, f.d.cp_link_tip_a);
            am.i(this.dQP, f.C0146f.god_recommend_right_button_selertor);
            this.dQK.setData(this.dQQ);
            this.mListView.setAdapter((ListAdapter) this.dQK);
            this.Qj.reset();
            this.Qj.b(this.mContext).xe();
        }
    }

    private void initUI() {
        if (this.dQJ == null) {
            this.dQJ = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(f.h.god_recommend_content_layout, (ViewGroup) null);
            this.dQL = (TextView) this.dQJ.findViewById(f.g.god_title);
            this.mTopLine = this.dQJ.findViewById(f.g.top_line);
            this.dQM = this.dQJ.findViewById(f.g.content_button_divider);
            this.dQN = (TextView) this.dQJ.findViewById(f.g.btn_to_do_leter);
            this.dQN.setOnClickListener(this);
            this.dQO = this.dQJ.findViewById(f.g.button_divider);
            this.dQP = (TextView) this.dQJ.findViewById(f.g.btn_attention_all);
            this.dQP.setOnClickListener(this);
            this.mListView = (ListView) this.dQJ.findViewById(f.g.listview);
            this.dQK = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dQK.setOnClickListener(this.mOnClickListener);
        }
        if (this.Qj == null) {
            this.Qj = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Qj.w(this.dQJ);
            this.Qj.ch(1);
            this.Qj.aw(true);
        }
    }

    private List<MetaData> aCF() {
        if (w.z(this.dQQ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dQQ) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData mt(int i) {
        return this.dQK.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!w.z(list) && aCH()) {
            boolean bL = bL(list);
            if (z) {
                if (bL) {
                    l.showToast(this.mActivity, f.j.attention_success);
                    ZD();
                    return;
                }
                this.dQK.setData(this.dQQ);
                l.showToast(this.mActivity, f.j.attention_fail);
            } else if (bL) {
                this.dQK.setData(this.dQQ);
                aCG();
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(f.j.attention_fail) : str;
    }

    private void aCG() {
        if (!w.z(this.dQR)) {
            int size = this.dQQ.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dQQ.get(size) == null || !this.dQQ.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dQQ.remove(size);
                        this.dQQ.add(this.dQR.remove(0));
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
                Iterator<MetaData> it = this.dQQ.iterator();
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
    public boolean aCH() {
        return this.Qj != null && this.Qj.isShowing();
    }

    public void ZD() {
        if (aCH()) {
            this.Qj.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.g.btn_to_do_leter) {
            this.Qj.dismiss();
        }
        if (id == f.g.btn_attention_all && this.dQE != null) {
            this.dQE.bJ(aCF());
        }
    }
}
