package com.baidu.tieba.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class l extends BaseAdapter {
    private com.baidu.tbadk.a a;
    private View.OnClickListener d;
    private ArrayList<AccountData> c = null;
    private boolean b = false;

    public l(com.baidu.tbadk.a aVar, View.OnClickListener onClickListener) {
        this.a = aVar;
        this.d = onClickListener;
    }

    public final void a(ArrayList<AccountData> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int i = 0;
        if (this.c != null) {
            i = this.c.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [138=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        View view2;
        try {
            try {
                try {
                    if (view == null) {
                        LayoutInflater from = LayoutInflater.from(this.a);
                        if (getItemViewType(i) == 0) {
                            view2 = from.inflate(com.baidu.tieba.a.i.account_item, (ViewGroup) null);
                            mVar = new m(this, (byte) 0);
                            mVar.a = (TextView) view2.findViewById(com.baidu.tieba.a.h.account);
                            mVar.c = (ImageView) view2.findViewById(com.baidu.tieba.a.h.active);
                            mVar.d = (Button) view2.findViewById(com.baidu.tieba.a.h.delete);
                            mVar.e = view2.findViewById(com.baidu.tieba.a.h.account_item_line_layout);
                            mVar.d.setOnClickListener(this.d);
                            view2.setTag(mVar);
                        } else {
                            view2 = from.inflate(com.baidu.tieba.a.i.account_add_item, (ViewGroup) null);
                            mVar = new m(this, (byte) 0);
                            mVar.b = (TextView) view2.findViewById(com.baidu.tieba.a.h.add_text);
                            view2.setTag(mVar);
                        }
                    } else {
                        mVar = (m) view.getTag();
                        view2 = view;
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkApplication.j().l() == 1) {
                            mVar.a.setTextColor(ba.a(1));
                        } else {
                            mVar.a.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        mVar.c.setVisibility(8);
                        mVar.d.setVisibility(8);
                        mVar.d.setTag(accountData);
                        if (accountData != null) {
                            mVar.a.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                mVar.c.setVisibility(0);
                            }
                            if (this.b) {
                                mVar.d.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            mVar.e.setVisibility(8);
                        } else {
                            mVar.e.setVisibility(0);
                        }
                    } else {
                        if (TbadkApplication.j().l() == 1) {
                            mVar.b.setTextColor(ba.a(1));
                        } else {
                            mVar.b.setTextColor(-12895429);
                        }
                        mVar.e.setVisibility(8);
                    }
                    this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
                    this.a.getLayoutMode().a(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", e.getMessage());
                    this.a.getLayoutMode().a(TbadkApplication.j().l() != 1);
                    this.a.getLayoutMode().a(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
                this.a.getLayoutMode().a(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", e.getMessage());
            this.a.getLayoutMode().a(TbadkApplication.j().l() != 1);
            this.a.getLayoutMode().a(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.a.getLayoutMode().a(view);
            throw th;
        }
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }
}
