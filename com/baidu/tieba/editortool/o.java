package com.baidu.tieba.editortool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer a;
    private final WriteImagesInfo b;

    public o(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.a = editorToolComponetContainer;
        this.b = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.b.getChosedFiles().get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        FrameLayout frameLayout;
        int i2;
        int i3;
        com.baidu.tbadk.img.e eVar;
        LayoutInflater layoutInflater;
        if (view == null) {
            layoutInflater = this.a.r;
            frameLayout = (FrameLayout) layoutInflater.inflate(com.baidu.tieba.a.i.editor_muti_image_item, (ViewGroup) null);
        } else {
            frameLayout = view;
        }
        int l = TbadkApplication.j().l();
        ImageFileInfo imageFileInfo = this.b.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.a.p;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.a.q;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.a.h.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.a.h.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.a.h.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            int i6 = l == 1 ? com.baidu.tieba.a.g.bg_add_photo_1 : com.baidu.tieba.a.g.bg_add_photo;
            int i7 = l == 1 ? com.baidu.tieba.a.g.bg_add_photo_foregroundselector_1 : com.baidu.tieba.a.g.bg_add_photo_foregroundselector;
            frameLayout3.setBackgroundResource(i6);
            frameLayout3.setForeground(this.a.getResources().getDrawable(i7));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.a(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.a.u;
            if (eVar.a(imageFileInfo, new p(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new q(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.a.h.delete);
        imageView.setImageResource(l == 1 ? com.baidu.tieba.a.g.btn_add_photo_close_n_1 : com.baidu.tieba.a.g.btn_add_photo_close_n);
        imageView.setOnClickListener(new r(this, frameLayout2));
        return frameLayout2;
    }
}
