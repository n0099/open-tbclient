package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class am extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f906a;
    public TextView b;
    public Button c;
    public Button d;
    public CheckBox e;
    private VersionData f;
    private CombineDownload g;
    private ap h;

    public am(Context context, int i) {
        super(context, i);
        this.g = null;
        this.h = null;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.update_dialog);
        this.f906a = (TextView) findViewById(R.id.newvison);
        this.b = (TextView) findViewById(R.id.desc);
        this.d = (Button) findViewById(R.id.update_button);
        this.c = (Button) findViewById(R.id.update_cancel);
        this.e = (CheckBox) findViewById(R.id.other_app_checkbox);
        this.f906a.setText("新版本：" + this.f.getNew_version());
        this.b.setText(this.f.getNew_version_desc());
        this.e.setText(this.g.getAppName());
        if (!com.baidu.tieba.util.am.f(getContext(), this.g.getAppProc()) && !TextUtils.isEmpty(this.g.getAppUrl())) {
            this.e.setChecked(true);
        } else {
            this.e.setChecked(false);
            this.e.setVisibility(8);
        }
        this.d.setOnClickListener(new an(this));
        this.c.setOnClickListener(new ao(this));
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ap apVar) {
        this.f = versionData;
        this.g = combineDownload;
        this.h = apVar;
    }
}
