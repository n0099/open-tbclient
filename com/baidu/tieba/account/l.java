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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener acD;
    private BaseActivity ate;
    private List<AccountData> aMv = null;
    private boolean aMu = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.ate = baseActivity;
        this.acD = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aMv = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aMv != null) {
            i = this.aMv.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMv == null || i < 0 || i >= this.aMv.size()) {
            return null;
        }
        return this.aMv.get(i);
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
                        view2 = LayoutInflater.from(this.ate.getPageContext().getContext()).inflate(u.h.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aMw = (TextView) view2.findViewById(u.g.account);
                        aVar.aMy = (ImageView) view2.findViewById(u.g.active);
                        aVar.aMz = (Button) view2.findViewById(u.g.delete);
                        aVar.ajP = view2.findViewById(u.g.account_item_line_layout);
                        aVar.aMz.setOnClickListener(this.acD);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.ate.getPageContext().getContext()).inflate(u.h.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aMx = (TextView) view2.findViewById(u.g.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aMy.setVisibility(8);
                        aVar.aMz.setVisibility(8);
                        aVar.aMz.setTag(accountData);
                        if (accountData != null) {
                            if (StringUtils.isNull(accountData.getDisplayName())) {
                                aVar.aMw.setText(accountData.getAccount());
                            } else {
                                aVar.aMw.setText(accountData.getDisplayName());
                            }
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aMy.setVisibility(0);
                            }
                            if (this.aMu) {
                                aVar.aMz.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.ajP.setVisibility(8);
                        } else {
                            aVar.ajP.setVisibility(0);
                        }
                    }
                    this.ate.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
                    this.ate.getLayoutMode().w(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.ate.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() != 1);
                    this.ate.getLayoutMode().w(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.ate.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
                this.ate.getLayoutMode().w(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.ate.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() != 1);
            this.ate.getLayoutMode().w(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.ate.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
            this.ate.getLayoutMode().w(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aMu = z;
    }

    public boolean IY() {
        return this.aMu;
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
        TextView aMw;
        TextView aMx;
        ImageView aMy;
        Button aMz;
        View ajP;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
