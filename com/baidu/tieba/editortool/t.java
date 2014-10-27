package com.baidu.tieba.editortool;

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
public class t extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer aqU;
    private final WriteImagesInfo aqX;

    public t(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.aqU = editorToolComponetContainer;
        this.aqX = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aqX == null) {
            return 0;
        }
        return this.aqX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aqX.getChosedFiles().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        int i3;
        com.baidu.tbadk.img.e eVar;
        FrameLayout frameLayout = view == null ? (FrameLayout) com.baidu.adp.lib.g.b.ek().inflate(this.aqU.mContext, com.baidu.tieba.w.editor_muti_image_item, null) : view;
        TbadkApplication.m251getInst().getSkinType();
        ImageFileInfo imageFileInfo = this.aqX.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.aqU.aqP;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.aqU.padding;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.v.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.v.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.v.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            com.baidu.tbadk.core.util.aw.h(frameLayout3, com.baidu.tieba.u.bg_add_photo);
            frameLayout3.setForeground(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_add_photo_foregroundselector));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.w(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.aqU.aqT;
            if (eVar.a(imageFileInfo, new u(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new v(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.v.delete);
        com.baidu.tbadk.core.util.aw.c(imageView, com.baidu.tieba.u.btn_add_photo_close_n);
        imageView.setOnClickListener(new w(this, frameLayout2));
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str) {
        new x(this, str).execute(new Void[0]);
    }
}
