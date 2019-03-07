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
    private com.baidu.tieba.enterForum.view.e eBe;
    private com.baidu.tieba.enterForum.view.a eDe;
    private a eDf;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private a.InterfaceC0242a eDg = new a.InterfaceC0242a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0242a
        public void lI(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new am("c13369").T("obj_type", i == 1 ? 2 : 1));
            b.this.aWF();
            if (b.this.eDf != null) {
                b.this.eDf.pc(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener bQJ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eBe.aXF() && view == b.this.mTitle) {
                if (b.this.eDe == null) {
                    b.this.eDe = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                    b.this.eDe.setOnDismissListener(b.this.mOnDismissListener);
                    b.this.eDe.a(b.this.eDg);
                    b.this.eDe.po(b.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i(b.this.mContext.getString(d.j.level_sort), 1));
                arrayList.add(new i(b.this.mContext.getString(d.j.update_sort), 2));
                b.this.eDe.setData(arrayList, b.this.mSortType);
                b.this.eDe.bg(b.this.mTitle);
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
        void pc(int i);
    }

    public b(Context context, int i, int i2, com.baidu.tieba.enterForum.view.e eVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eBe = eVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void aWF() {
        if (aWG() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(d.j.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(d.j.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.bQJ);
        }
    }

    public boolean aWG() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (aWG()) {
            this.mSortType = i;
            aWF();
        }
    }

    public void a(a aVar) {
        this.eDf = aVar;
    }
}
