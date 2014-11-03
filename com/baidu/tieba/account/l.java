package com.baidu.tieba.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener If;
    private BaseActivity Or;
    private ArrayList<AccountData> aeE = null;
    private boolean aeD = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.Or = baseActivity;
        this.If = onClickListener;
    }

    public void setData(ArrayList<AccountData> arrayList) {
        this.aeE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aeE != null) {
            i = this.aeE.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aeE == null || i < 0 || i >= this.aeE.size()) {
            return null;
        }
        return this.aeE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        mVar = (m) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.Or, com.baidu.tieba.w.account_item, null);
                        mVar = new m(this, null);
                        mVar.aeF = (TextView) view2.findViewById(com.baidu.tieba.v.account);
                        mVar.aeH = (ImageView) view2.findViewById(com.baidu.tieba.v.active);
                        mVar.aeI = (Button) view2.findViewById(com.baidu.tieba.v.delete);
                        mVar.ML = view2.findViewById(com.baidu.tieba.v.account_item_line_layout);
                        mVar.aeI.setOnClickListener(this.If);
                        view2.setTag(mVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.Or, com.baidu.tieba.w.account_add_item, null);
                        mVar = new m(this, null);
                        mVar.aeG = (TextView) view2.findViewById(com.baidu.tieba.v.add_text);
                        view2.setTag(mVar);
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkApplication.m251getInst().getSkinType() == 1) {
                            mVar.aeF.setTextColor(aw.bx(1));
                        } else {
                            mVar.aeF.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        mVar.aeH.setVisibility(8);
                        mVar.aeI.setVisibility(8);
                        mVar.aeI.setTag(accountData);
                        if (accountData != null) {
                            mVar.aeF.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                mVar.aeH.setVisibility(0);
                            }
                            if (this.aeD) {
                                mVar.aeI.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            mVar.ML.setVisibility(8);
                        } else {
                            mVar.ML.setVisibility(0);
                        }
                    } else if (TbadkApplication.m251getInst().getSkinType() == 1) {
                        mVar.aeG.setTextColor(aw.bx(1));
                    } else {
                        mVar.aeG.setTextColor(-12895429);
                    }
                    this.Or.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                    this.Or.getLayoutMode().h(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.Or.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() != 1);
                    this.Or.getLayoutMode().h(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.Or.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                this.Or.getLayoutMode().h(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.Or.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() != 1);
            this.Or.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.Or.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.Or.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aeD = z;
    }

    public boolean xf() {
        return this.aeD;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
