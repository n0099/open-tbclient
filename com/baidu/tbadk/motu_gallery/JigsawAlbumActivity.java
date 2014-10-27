package com.baidu.tbadk.motu_gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class JigsawAlbumActivity extends BaseActivity {
    private static boolean Wk = false;
    private static boolean Wl = true;
    private Cursor Wc;
    private j Wg;
    private ListView Wh;
    private u Wi;
    private l Wj;
    TextView Wr;
    private LinearLayout Ws;
    private ArrayList<c> Wd = new ArrayList<>();
    private ArrayList<c> We = new ArrayList<>();
    private Map<String, Integer> map = new HashMap();
    private Map<String, Bitmap> Wf = new LinkedHashMap();
    private NavigationBar mNavigationBar = null;
    private final int Wm = 0;
    private final int Wn = 1;
    private final int Wo = 2;
    private byte[] Wp = new byte[1];
    private boolean Wq = false;
    private Handler mHandler = new Handler(new d(this));
    private Runnable mRunnable = new e(this);
    int Wt = 0;
    int Wu = 0;

    public static void h(Context context, int i) {
        Intent intent = new Intent(context, JigsawAlbumActivity.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    public boolean sF() {
        return Wk;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (sF()) {
            Wk = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(com.baidu.tieba.w.motu_albums_activity);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            y.dc(com.baidu.tieba.y.oom_retry);
        }
        this.Wr = (TextView) findViewById(com.baidu.tieba.v.jigsaw_selected_text);
        this.Wi = u.sM();
        this.Wi.B(this);
        this.Wh = (ListView) findViewById(com.baidu.tieba.v.albums_list);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.jigsaw_photo_storage));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_textbtn, new g(this))).setText(com.baidu.tieba.y.jigsaw_start);
        this.Wg = new j(this, this);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.Wh.setAdapter((ListAdapter) this.Wg);
        this.Wh.setOnItemClickListener(new h(this));
        this.Ws = (LinearLayout) findViewById(com.baidu.tieba.v.selected_ll);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Wl = true;
        this.Wq = false;
        this.Wr.setText(this.Wi.E(this));
        if (this.Wi.sO()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        sG();
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
    }

    private void sG() {
        this.Ws.removeAllViews();
        for (Uri uri : this.Wi.C(this)) {
            x xVar = new x(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.g(uri)) {
                this.Ws.addView(xVar);
                xVar.setOnClickListener(new i(this, xVar));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.Wf.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ce A[LOOP:0: B:66:0x004a->B:65:0x01ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0069 A[EDGE_INSN: B:73:0x0069->B:15:0x0069 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void refresh() {
        int i;
        synchronized (this.Wp) {
            try {
                this.Wd.clear();
                this.We.clear();
                this.Wc = null;
                this.Wc = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (this.Wc != null && this.Wc.getCount() > 0) {
                    this.Wc.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = this.Wc.getString(this.Wc.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = this.Wc.getInt(this.Wc.getColumnIndexOrThrow("_id"));
                                if (dJ(this.Wc.getString(this.Wc.getColumnIndexOrThrow("_display_name"))) < 0) {
                                    i = i2;
                                } else {
                                    String substring = string.substring(0, string.lastIndexOf("/"));
                                    if (!dI(substring)) {
                                        if (substring != null && substring.endsWith(TbConfig.getTempDirName()) && !this.We.isEmpty()) {
                                            c remove = this.We.remove(0);
                                            this.We.add(0, new c(0, substring, 0));
                                            int intValue = this.map.get(String.valueOf(0)).intValue();
                                            this.map.put(String.valueOf(0), 1);
                                            i = this.We.size();
                                            try {
                                                remove.type = i;
                                                this.We.add(remove);
                                                this.map.put(String.valueOf(i), Integer.valueOf(intValue));
                                                x(0, i);
                                                this.Wd.add(new c(0, string, i3));
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                if (this.Wc.moveToNext()) {
                                                }
                                            }
                                        } else {
                                            i = this.We.size();
                                            this.We.add(new c(i, substring, 0));
                                            this.map.put(String.valueOf(i), 1);
                                            this.Wd.add(new c(i, string, i3));
                                        }
                                    } else {
                                        i = i2;
                                        int i4 = 0;
                                        while (i4 < this.We.size()) {
                                            if (this.We.get(i4).path.equals(substring)) {
                                                i = this.We.get(i4).type;
                                                this.map.put(String.valueOf(i), Integer.valueOf(this.map.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i4++;
                                            i = i;
                                        }
                                        this.Wd.add(new c(i, string, i3));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (this.Wc.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (this.Wc != null) {
                    this.Wc.close();
                }
                this.Wc = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.Wc != null) {
                    this.Wc.close();
                }
                this.Wc = null;
            }
        }
    }

    private void x(int i, int i2) {
        if (this.Wd != null) {
            Iterator<c> it = this.Wd.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.type == i) {
                    next.type = i2;
                } else if (next.type == i2) {
                    next.type = i;
                }
            }
        }
    }

    private boolean dI(String str) {
        for (int i = 0; i < this.We.size(); i++) {
            if (this.We.get(i).path.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int dJ(String str) {
        String substring = str.substring(str.lastIndexOf(".") + 1);
        if (substring.equalsIgnoreCase("jpg") || substring.equalsIgnoreCase("jpeg") || substring.equalsIgnoreCase("jpe")) {
            return 0;
        }
        if (substring.equalsIgnoreCase("png")) {
            return 1;
        }
        if (substring.equalsIgnoreCase("bmp")) {
            return 2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cY(int i) {
        Iterator<c> it = this.Wd.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next.path;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cZ(int i) {
        Iterator<c> it = this.Wd.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH() {
        if (Wl) {
            Wl = false;
            setResult(-1, u.sM().sP());
            finish();
        }
    }

    public int s(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (10 == i && 2 == i2) {
            sH();
        }
    }
}
