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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ae extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f918a;
    public TextView b;
    public Button c;
    public Button d;
    public CheckBox e;
    private VersionData f;
    private CombineDownload g;
    private ah h;

    public ae(Context context, int i) {
        super(context, i);
        this.g = null;
        this.h = null;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.update_dialog);
        this.f918a = (TextView) findViewById(R.id.newvison);
        this.b = (TextView) findViewById(R.id.desc);
        this.d = (Button) findViewById(R.id.update_button);
        this.c = (Button) findViewById(R.id.update_cancel);
        this.e = (CheckBox) findViewById(R.id.other_app_checkbox);
        this.f918a.setText("新版本：" + this.f.getNew_version());
        this.b.setText(this.f.getNew_version_desc());
        this.e.setText(this.g.getAppName());
        if (!UtilHelper.f(getContext(), this.g.getAppProc()) && !TextUtils.isEmpty(this.g.getAppUrl())) {
            this.e.setChecked(true);
        } else {
            this.e.setChecked(false);
            this.e.setVisibility(8);
        }
        this.d.setOnClickListener(new af(this));
        this.c.setOnClickListener(new ag(this));
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.f = versionData;
        this.g = combineDownload;
        this.h = ahVar;
    }
}
