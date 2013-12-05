package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ImageUploadView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1271a;
    private Button b;
    private Button c;

    public ImageUploadView(Context context) {
        super(context);
        this.f1271a = context;
        b();
    }

    public ImageUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1271a = context;
        b();
    }

    private void b() {
        LayoutInflater.from(this.f1271a).inflate(R.layout.image_upload_view, (ViewGroup) this, true);
        this.b = (Button) findViewById(R.id.btn_image_upload_camera);
        this.c = (Button) findViewById(R.id.btn_image_upload_album);
    }

    public void setOnClickListener(h hVar) {
        i iVar = new i(this, hVar);
        this.b.setOnClickListener(iVar);
        this.c.setOnClickListener(iVar);
    }

    public boolean a() {
        return false;
    }
}
