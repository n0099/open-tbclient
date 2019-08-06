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
    private com.baidu.tbadk.core.dialog.a TX;
    private a gaA;
    private ViewGroup gaF;
    private com.baidu.tieba.godRecommends.a gaG;
    private TextView gaH;
    private View gaI;
    private TextView gaJ;
    private View gaK;
    private TextView gaL;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> gaM = new ArrayList();
    private List<MetaData> gaN = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.buD()) {
                if (!d.this.cw(d.this.gaM)) {
                    d.this.gaG.setData(d.this.gaM);
                } else {
                    d.this.azR();
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
        this.gaA = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.buA())) {
            azR();
            this.gaM.clear();
            this.gaN.clear();
            List<MetaData> buA = cVar.buA();
            int size = buA.size();
            if (size <= 3) {
                this.gaM.addAll(buA);
            } else {
                this.gaM.addAll(buA.subList(0, 3));
                this.gaN.addAll(buA.subList(3, size));
            }
            initUI();
            this.gaH.setText(R.string.god_recommend_title);
            am.k(this.gaF, R.drawable.bg_god_recommend_layout);
            am.j(this.gaH, R.color.cp_cont_d);
            am.l(this.mTopLine, R.color.cp_bg_line_b);
            am.l(this.gaI, R.color.cp_bg_line_a);
            am.j(this.gaJ, R.color.cp_cont_f);
            am.k(this.gaJ, R.drawable.god_recommend_left_button_selector);
            am.l(this.gaK, R.color.cp_bg_line_a);
            am.j(this.gaL, R.color.cp_link_tip_a);
            am.k(this.gaL, R.drawable.god_recommend_right_button_selertor);
            this.gaG.setData(this.gaM);
            this.mListView.setAdapter((ListAdapter) this.gaG);
            this.TX.reset();
            this.TX.b(this.mContext).agK();
        }
    }

    private void initUI() {
        if (this.gaF == null) {
            this.gaF = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.gaH = (TextView) this.gaF.findViewById(R.id.god_title);
            this.mTopLine = this.gaF.findViewById(R.id.top_line);
            this.gaI = this.gaF.findViewById(R.id.content_button_divider);
            this.gaJ = (TextView) this.gaF.findViewById(R.id.btn_to_do_leter);
            this.gaJ.setOnClickListener(this);
            this.gaK = this.gaF.findViewById(R.id.button_divider);
            this.gaL = (TextView) this.gaF.findViewById(R.id.btn_attention_all);
            this.gaL.setOnClickListener(this);
            this.mListView = (ListView) this.gaF.findViewById(R.id.listview);
            this.gaG = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.gaG.setOnClickListener(this.mOnClickListener);
        }
        if (this.TX == null) {
            this.TX = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TX.aH(this.gaF);
            this.TX.hx(1);
            this.TX.dR(true);
        }
    }

    private List<MetaData> buB() {
        if (v.aa(this.gaM)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.gaM) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData tC(int i) {
        return this.gaG.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && buD()) {
            boolean cv = cv(list);
            if (z) {
                if (cv) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    azR();
                    return;
                }
                this.gaG.setData(this.gaM);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cv) {
                this.gaG.setData(this.gaM);
                buC();
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

    private void buC() {
        if (!v.aa(this.gaN)) {
            int size = this.gaM.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.gaM.get(size) == null || !this.gaM.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.gaM.remove(size);
                        this.gaM.add(this.gaN.remove(0));
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
                Iterator<MetaData> it = this.gaM.iterator();
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
    public boolean buD() {
        return this.TX != null && this.TX.isShowing();
    }

    public void azR() {
        if (buD()) {
            this.TX.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.TX.dismiss();
        }
        if (id == R.id.btn_attention_all && this.gaA != null) {
            this.gaA.ct(buB());
        }
    }
}
