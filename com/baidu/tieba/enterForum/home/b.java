package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.enterForum.view.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private com.baidu.tieba.enterForum.view.e eAM;
    private com.baidu.tieba.enterForum.view.a eCM;
    private a eCN;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private a.InterfaceC0283a eCO = new a.InterfaceC0283a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0283a
        public void lH(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new am("c13369").T("obj_type", i == 1 ? 2 : 1));
            b.this.aWD();
            if (b.this.eCN != null) {
                b.this.eCN.oY(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener bQN = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eAM.aXC() && view == b.this.mTitle) {
                if (b.this.eCM == null) {
                    b.this.eCM = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                    b.this.eCM.setOnDismissListener(b.this.mOnDismissListener);
                    b.this.eCM.a(b.this.eCO);
                    b.this.eCM.pj(b.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i(b.this.mContext.getString(d.j.level_sort), 1));
                arrayList.add(new i(b.this.mContext.getString(d.j.update_sort), 2));
                b.this.eCM.setData(arrayList, b.this.mSortType);
                b.this.eCM.bg(b.this.mTitle);
                b.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow_up_n), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.mTitle != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.mTitle.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void oY(int i);
    }

    public b(Context context, int i, int i2, com.baidu.tieba.enterForum.view.e eVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eAM = eVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void aWD() {
        if (aWE() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(d.j.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(d.j.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.bQN);
        }
    }

    public boolean aWE() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (aWE()) {
            this.mSortType = i;
            aWD();
        }
    }

    public void a(a aVar) {
        this.eCN = aVar;
    }
}
