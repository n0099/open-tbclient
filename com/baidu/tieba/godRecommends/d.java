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
    private com.baidu.tbadk.core.dialog.a CM;
    private TbPageContext<?> ceu;
    private a gaY;
    private ViewGroup gbd;
    private com.baidu.tieba.godRecommends.a gbe;
    private TextView gbf;
    private View gbg;
    private TextView gbh;
    private View gbi;
    private TextView gbj;
    private Activity mActivity;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> gbk = new ArrayList();
    private List<MetaData> gbl = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bsu()) {
                if (!d.this.cJ(d.this.gbk)) {
                    d.this.gbe.setData(d.this.gbk);
                } else {
                    d.this.aAk();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cG(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.gaY = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.isEmpty(cVar.bsr())) {
            aAk();
            this.gbk.clear();
            this.gbl.clear();
            List<MetaData> bsr = cVar.bsr();
            int size = bsr.size();
            if (size <= 3) {
                this.gbk.addAll(bsr);
            } else {
                this.gbk.addAll(bsr.subList(0, 3));
                this.gbl.addAll(bsr.subList(3, size));
            }
            initUI();
            this.gbf.setText(R.string.god_recommend_title);
            am.setBackgroundResource(this.gbd, R.drawable.bg_god_recommend_layout);
            am.setViewTextColor(this.gbf, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gbg, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gbh, (int) R.color.cp_cont_f);
            am.setBackgroundResource(this.gbh, R.drawable.god_recommend_left_button_selector);
            am.setBackgroundColor(this.gbi, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gbj, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.gbj, R.drawable.god_recommend_right_button_selertor);
            this.gbe.setData(this.gbk);
            this.mListView.setAdapter((ListAdapter) this.gbe);
            this.CM.reset();
            this.CM.b(this.ceu).akM();
        }
    }

    private void initUI() {
        if (this.gbd == null) {
            this.gbd = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.gbf = (TextView) this.gbd.findViewById(R.id.god_title);
            this.mTopLine = this.gbd.findViewById(R.id.top_line);
            this.gbg = this.gbd.findViewById(R.id.content_button_divider);
            this.gbh = (TextView) this.gbd.findViewById(R.id.btn_to_do_leter);
            this.gbh.setOnClickListener(this);
            this.gbi = this.gbd.findViewById(R.id.button_divider);
            this.gbj = (TextView) this.gbd.findViewById(R.id.btn_attention_all);
            this.gbj.setOnClickListener(this);
            this.mListView = (ListView) this.gbd.findViewById(R.id.listview);
            this.gbe = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.gbe.setOnClickListener(this.mOnClickListener);
        }
        if (this.CM == null) {
            this.CM = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.CM.aM(this.gbd);
            this.CM.hW(1);
            this.CM.eh(true);
        }
    }

    private List<MetaData> bss() {
        if (v.isEmpty(this.gbk)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.gbk) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData sA(int i) {
        return this.gbe.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.isEmpty(list) && bsu()) {
            boolean cI = cI(list);
            if (z) {
                if (cI) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    aAk();
                    return;
                }
                this.gbe.setData(this.gbk);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cI) {
                this.gbe.setData(this.gbk);
                bst();
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

    private void bst() {
        if (!v.isEmpty(this.gbl)) {
            int size = this.gbk.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.gbk.get(size) == null || !this.gbk.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.gbk.remove(size);
                        this.gbk.add(this.gbl.remove(0));
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
                Iterator<MetaData> it = this.gbk.iterator();
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
    public boolean bsu() {
        return this.CM != null && this.CM.isShowing();
    }

    public void aAk() {
        if (bsu()) {
            this.CM.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.CM.dismiss();
        }
        if (id == R.id.btn_attention_all && this.gaY != null) {
            this.gaY.cG(bss());
        }
    }
}
