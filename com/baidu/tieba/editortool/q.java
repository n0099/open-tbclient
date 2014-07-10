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
public class q extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer a;
    private final WriteImagesInfo b;

    public q(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.a = editorToolComponetContainer;
        this.b = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.getChosedFiles().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        FrameLayout frameLayout;
        int i2;
        int i3;
        com.baidu.tbadk.img.e eVar;
        LayoutInflater layoutInflater;
        if (view == null) {
            layoutInflater = this.a.v;
            frameLayout = (FrameLayout) layoutInflater.inflate(com.baidu.tieba.w.editor_muti_image_item, (ViewGroup) null);
        } else {
            frameLayout = view;
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ImageFileInfo imageFileInfo = this.b.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.a.t;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.a.u;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.v.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.v.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.v.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            int i6 = skinType == 1 ? com.baidu.tieba.u.bg_add_photo_1 : com.baidu.tieba.u.bg_add_photo;
            int i7 = skinType == 1 ? com.baidu.tieba.u.bg_add_photo_foregroundselector_1 : com.baidu.tieba.u.bg_add_photo_foregroundselector;
            frameLayout3.setBackgroundResource(i6);
            frameLayout3.setForeground(this.a.getResources().getDrawable(i7));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.a(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.a.z;
            if (eVar.a(imageFileInfo, new r(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new s(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.v.delete);
        imageView.setImageResource(skinType == 1 ? com.baidu.tieba.u.btn_add_photo_close_n_1 : com.baidu.tieba.u.btn_add_photo_close_n);
        imageView.setOnClickListener(new t(this, frameLayout2));
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        new u(this, str).execute(new Void[0]);
    }
}
