package com.baidu.tbadk.mvc.c.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public abstract class e extends a {
    private DialogInterface.OnClickListener dialogClickListener;
    private AdapterView.OnItemClickListener itemClickListener;
    private AdapterView.OnItemLongClickListener itemLongClickListener;
    private View.OnClickListener rootViewClickListener;
    private View.OnLongClickListener rootViewLongClickListener;

    public View.OnClickListener setViewClickListener(View view, com.baidu.tbadk.mvc.c.b bVar) {
        if (view == null || bVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(bVar, view);
        if (this.rootViewClickListener == null) {
            this.rootViewClickListener = new f(this);
        }
        view.setOnClickListener(this.rootViewClickListener);
        return this.rootViewClickListener;
    }

    public View.OnLongClickListener setViewLongClickListener(View view, com.baidu.tbadk.mvc.c.b bVar) {
        if (view == null || bVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(bVar, view);
        if (this.rootViewLongClickListener == null) {
            this.rootViewLongClickListener = new g(this);
        }
        view.setOnLongClickListener(this.rootViewLongClickListener);
        return this.rootViewLongClickListener;
    }

    public DialogInterface.OnClickListener setDialogClickListener(Dialog dialog, com.baidu.tbadk.mvc.c.b bVar) {
        if (dialog == null || bVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(bVar, dialog);
        if (this.dialogClickListener == null) {
            this.dialogClickListener = new h(this);
        }
        return this.dialogClickListener;
    }

    public AdapterView.OnItemClickListener setItemClickListener(View view, com.baidu.tbadk.mvc.c.b bVar) {
        if (view == null || bVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(bVar, view);
        if (this.itemClickListener == null) {
            this.itemClickListener = new i(this);
        }
        return this.itemClickListener;
    }

    public AdapterView.OnItemLongClickListener setItemLongClickListener(View view, com.baidu.tbadk.mvc.c.b bVar) {
        if (view == null || bVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(bVar, view);
        if (this.itemLongClickListener == null) {
            this.itemLongClickListener = new j(this);
        }
        return this.itemLongClickListener;
    }
}
