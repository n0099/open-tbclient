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
    private View.OnClickListener afL;
    private BaseActivity awe;
    private List<AccountData> aUm = null;
    private boolean aUl = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.awe = baseActivity;
        this.afL = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aUm = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aUm != null) {
            i = this.aUm.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUm == null || i < 0 || i >= this.aUm.size()) {
            return null;
        }
        return this.aUm.get(i);
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
                        view2 = LayoutInflater.from(this.awe.getPageContext().getContext()).inflate(r.h.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aUn = (TextView) view2.findViewById(r.g.account);
                        aVar.aUp = (ImageView) view2.findViewById(r.g.active);
                        aVar.aUq = (Button) view2.findViewById(r.g.delete);
                        aVar.amY = view2.findViewById(r.g.account_item_line_layout);
                        aVar.aUq.setOnClickListener(this.afL);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.awe.getPageContext().getContext()).inflate(r.h.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aUo = (TextView) view2.findViewById(r.g.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aUp.setVisibility(8);
                        aVar.aUq.setVisibility(8);
                        aVar.aUq.setTag(accountData);
                        if (accountData != null) {
                            if (StringUtils.isNull(accountData.getDisplayName())) {
                                aVar.aUn.setText(accountData.getAccount());
                            } else {
                                aVar.aUn.setText(accountData.getDisplayName());
                            }
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aUp.setVisibility(0);
                            }
                            if (this.aUl) {
                                aVar.aUq.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.amY.setVisibility(8);
                        } else {
                            aVar.amY.setVisibility(0);
                        }
                    }
                    this.awe.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                    this.awe.getLayoutMode().x(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.awe.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() != 1);
                    this.awe.getLayoutMode().x(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.awe.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                this.awe.getLayoutMode().x(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.awe.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() != 1);
            this.awe.getLayoutMode().x(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.awe.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
            this.awe.getLayoutMode().x(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aUl = z;
    }

    public boolean Mf() {
        return this.aUl;
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
        TextView aUn;
        TextView aUo;
        ImageView aUp;
        Button aUq;
        View amY;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
