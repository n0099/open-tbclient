package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    private f haM;
    private com.baidu.tieba.enterForum.view.a hcR;
    private a hcS;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean hcT = false;
    private a.InterfaceC0611a hcU = new a.InterfaceC0611a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0611a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ao("c13369").ag("obj_type", i == 1 ? 2 : 1));
            b.this.bRY();
            if (b.this.hcS != null) {
                b.this.hcS.tm(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener ebA = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.haM.bTE()) {
                if (view == b.this.mTitle) {
                    if (b.this.hcR == null) {
                        b.this.hcR = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.hcR.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.hcR.a(b.this.hcU);
                        b.this.hcR.tF(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new i(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new i(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.hcR.setData(arrayList, b.this.mSortType);
                    b.this.hcR.L(b.this.mTitle);
                }
                b.this.hcT = true;
                b.this.ms(b.this.hcT);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.hcT = false;
            b.this.ms(b.this.hcT);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void tm(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.haM = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void Jd() {
        if (this.hcR != null) {
            this.hcR.Jd();
        }
    }

    public void bRY() {
        if (bRZ() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.ebA);
            ms(this.hcT);
        }
    }

    public boolean bRZ() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bRZ()) {
            this.mSortType = i;
            bRY();
        }
    }

    public void a(a aVar) {
        this.hcS = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bRZ()) {
            an.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                ms(this.hcT);
            }
        }
        if (this.hcR != null && this.hcT) {
            this.hcR.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c bTK = this.haM != null ? this.haM.bTK() : null;
        if (bTK != null && bTK.hbs) {
            if (this.haM != null && this.haM.isShow()) {
                an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
