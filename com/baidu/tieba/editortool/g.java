package com.baidu.tieba.editortool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer a;
    private WriteImagesInfo b;

    public g(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
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
        com.baidu.tieba.img.e eVar;
        LayoutInflater layoutInflater;
        if (view == null) {
            layoutInflater = this.a.p;
            frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
        } else {
            frameLayout = view;
        }
        int ae = TiebaApplication.g().ae();
        ImageFileInfo imageFileInfo = this.b.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.a.n;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.a.o;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(R.id.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(R.id.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(R.id.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            int i6 = ae == 1 ? R.drawable.bg_add_photo_1 : R.drawable.bg_add_photo;
            int i7 = ae == 1 ? R.drawable.bg_add_photo_foregroundselector_1 : R.drawable.bg_add_photo_foregroundselector;
            frameLayout3.setBackgroundResource(i6);
            frameLayout3.setForeground(this.a.getResources().getDrawable(i7));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tieba.img.effects.d.a(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.a.s;
            if (eVar.a(imageFileInfo, new h(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new i(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
        imageView.setImageResource(ae == 1 ? R.drawable.btn_add_photo_close_n_1 : R.drawable.btn_add_photo_close_n);
        imageView.setOnClickListener(new j(this, frameLayout2));
        return frameLayout2;
    }
}
