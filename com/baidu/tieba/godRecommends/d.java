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
    private com.baidu.tbadk.core.dialog.a Do;
    private TbPageContext<?> cfl;
    private a gbP;
    private ViewGroup gbU;
    private com.baidu.tieba.godRecommends.a gbV;
    private TextView gbW;
    private View gbX;
    private TextView gbY;
    private View gbZ;
    private TextView gca;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> gcb = new ArrayList();
    private List<MetaData> gcc = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bsw()) {
                if (!d.this.cJ(d.this.gcb)) {
                    d.this.gbV.setData(d.this.gcb);
                } else {
                    d.this.aAm();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cG(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.gbP = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.isEmpty(cVar.bst())) {
            aAm();
            this.gcb.clear();
            this.gcc.clear();
            List<MetaData> bst = cVar.bst();
            int size = bst.size();
            if (size <= 3) {
                this.gcb.addAll(bst);
            } else {
                this.gcb.addAll(bst.subList(0, 3));
                this.gcc.addAll(bst.subList(3, size));
            }
            initUI();
            this.gbW.setText(R.string.god_recommend_title);
            am.setBackgroundResource(this.gbU, R.drawable.bg_god_recommend_layout);
            am.setViewTextColor(this.gbW, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gbX, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gbY, (int) R.color.cp_cont_f);
            am.setBackgroundResource(this.gbY, R.drawable.god_recommend_left_button_selector);
            am.setBackgroundColor(this.gbZ, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gca, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.gca, R.drawable.god_recommend_right_button_selertor);
            this.gbV.setData(this.gcb);
            this.mListView.setAdapter((ListAdapter) this.gbV);
            this.Do.reset();
            this.Do.b(this.cfl).akO();
        }
    }

    private void initUI() {
        if (this.gbU == null) {
            this.gbU = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.gbW = (TextView) this.gbU.findViewById(R.id.god_title);
            this.mTopLine = this.gbU.findViewById(R.id.top_line);
            this.gbX = this.gbU.findViewById(R.id.content_button_divider);
            this.gbY = (TextView) this.gbU.findViewById(R.id.btn_to_do_leter);
            this.gbY.setOnClickListener(this);
            this.gbZ = this.gbU.findViewById(R.id.button_divider);
            this.gca = (TextView) this.gbU.findViewById(R.id.btn_attention_all);
            this.gca.setOnClickListener(this);
            this.mListView = (ListView) this.gbU.findViewById(R.id.listview);
            this.gbV = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.gbV.setOnClickListener(this.mOnClickListener);
        }
        if (this.Do == null) {
            this.Do = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Do.aM(this.gbU);
            this.Do.hX(1);
            this.Do.eh(true);
        }
    }

    private List<MetaData> bsu() {
        if (v.isEmpty(this.gcb)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.gcb) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData sB(int i) {
        return this.gbV.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.isEmpty(list) && bsw()) {
            boolean cI = cI(list);
            if (z) {
                if (cI) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    aAm();
                    return;
                }
                this.gbV.setData(this.gcb);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cI) {
                this.gbV.setData(this.gcb);
                bsv();
            } else {
                l.showToast(this.mActivity, cH(list));
            }
        }
    }

    private String cH(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.isEmpty(list)) {
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

    private void bsv() {
        if (!v.isEmpty(this.gcc)) {
            int size = this.gcb.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.gcb.get(size) == null || !this.gcb.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.gcb.remove(size);
                        this.gcb.add(this.gcc.remove(0));
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

    private boolean cI(List<MFollowResult> list) {
        if (v.isEmpty(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.gcb.iterator();
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
    public boolean cJ(List<MetaData> list) {
        if (!v.isEmpty(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsw() {
        return this.Do != null && this.Do.isShowing();
    }

    public void aAm() {
        if (bsw()) {
            this.Do.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.Do.dismiss();
        }
        if (id == R.id.btn_attention_all && this.gbP != null) {
            this.gbP.cG(bsu());
        }
    }
}
