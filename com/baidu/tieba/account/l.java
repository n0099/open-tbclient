package com.baidu.tieba.account;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener aeY;
    private BaseActivity mContext;
    private List<AccountData> aPE = null;
    private boolean aPD = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.aeY = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aPE = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aPE != null) {
            i = this.aPE.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aPE == null || i < 0 || i >= this.aPE.size()) {
            return null;
        }
        return this.aPE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        aVar = (a) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(r.j.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aPF = (TextView) view2.findViewById(r.h.account);
                        aVar.aPH = (ImageView) view2.findViewById(r.h.active);
                        aVar.aPI = (Button) view2.findViewById(r.h.delete);
                        aVar.ame = view2.findViewById(r.h.account_item_line_layout);
                        aVar.aPI.setOnClickListener(this.aeY);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(r.j.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aPG = (TextView) view2.findViewById(r.h.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aPH.setVisibility(8);
                        aVar.aPI.setVisibility(8);
                        aVar.aPI.setTag(accountData);
                        if (accountData != null) {
                            if (StringUtils.isNull(accountData.getDisplayName())) {
                                aVar.aPF.setText(accountData.getAccount());
                            } else {
                                aVar.aPF.setText(accountData.getDisplayName());
                            }
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aPH.setVisibility(0);
                            }
                            if (this.aPD) {
                                aVar.aPI.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.ame.setVisibility(8);
                        } else {
                            aVar.ame.setVisibility(0);
                        }
                    }
                    this.mContext.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().v(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.mContext.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() != 1);
                    this.mContext.getLayoutMode().v(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.mContext.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().v(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.mContext.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() != 1);
            this.mContext.getLayoutMode().v(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.mContext.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().v(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aPD = z;
    }

    public boolean KU() {
        return this.aPD;
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

    /* loaded from: classes.dex */
    private class a {
        TextView aPF;
        TextView aPG;
        ImageView aPH;
        Button aPI;
        View ame;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
