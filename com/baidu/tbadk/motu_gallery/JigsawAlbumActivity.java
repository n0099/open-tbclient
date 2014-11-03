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
    private static boolean Wo = false;
    private static boolean Wp = true;
    private Cursor Wg;
    private j Wk;
    private ListView Wl;
    private u Wm;
    private l Wn;
    TextView Wv;
    private LinearLayout Ww;
    private ArrayList<c> Wh = new ArrayList<>();
    private ArrayList<c> Wi = new ArrayList<>();
    private Map<String, Integer> map = new HashMap();
    private Map<String, Bitmap> Wj = new LinkedHashMap();
    private NavigationBar mNavigationBar = null;
    private final int Wq = 0;
    private final int Wr = 1;
    private final int Ws = 2;
    private byte[] Wt = new byte[1];
    private boolean Wu = false;
    private Handler mHandler = new Handler(new d(this));
    private Runnable mRunnable = new e(this);
    int Wx = 0;
    int Wy = 0;

    public static void h(Context context, int i) {
        Intent intent = new Intent(context, JigsawAlbumActivity.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    public boolean sH() {
        return Wo;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (sH()) {
            Wo = false;
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
        this.Wv = (TextView) findViewById(com.baidu.tieba.v.jigsaw_selected_text);
        this.Wm = u.sO();
        this.Wm.B(this);
        this.Wl = (ListView) findViewById(com.baidu.tieba.v.albums_list);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.jigsaw_photo_storage));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_textbtn, new g(this))).setText(com.baidu.tieba.y.jigsaw_start);
        this.Wk = new j(this, this);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.Wl.setAdapter((ListAdapter) this.Wk);
        this.Wl.setOnItemClickListener(new h(this));
        this.Ww = (LinearLayout) findViewById(com.baidu.tieba.v.selected_ll);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Wp = true;
        this.Wu = false;
        this.Wv.setText(this.Wm.E(this));
        if (this.Wm.sQ()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        sI();
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
    }

    private void sI() {
        this.Ww.removeAllViews();
        for (Uri uri : this.Wm.C(this)) {
            x xVar = new x(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.t.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.g(uri)) {
                this.Ww.addView(xVar);
                xVar.setOnClickListener(new i(this, xVar));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.Wj.clear();
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
        synchronized (this.Wt) {
            try {
                this.Wh.clear();
                this.Wi.clear();
                this.Wg = null;
                this.Wg = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (this.Wg != null && this.Wg.getCount() > 0) {
                    this.Wg.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = this.Wg.getString(this.Wg.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = this.Wg.getInt(this.Wg.getColumnIndexOrThrow("_id"));
                                if (dJ(this.Wg.getString(this.Wg.getColumnIndexOrThrow("_display_name"))) < 0) {
                                    i = i2;
                                } else {
                                    String substring = string.substring(0, string.lastIndexOf("/"));
                                    if (!dI(substring)) {
                                        if (substring != null && substring.endsWith(TbConfig.getTempDirName()) && !this.Wi.isEmpty()) {
                                            c remove = this.Wi.remove(0);
                                            this.Wi.add(0, new c(0, substring, 0));
                                            int intValue = this.map.get(String.valueOf(0)).intValue();
                                            this.map.put(String.valueOf(0), 1);
                                            i = this.Wi.size();
                                            try {
                                                remove.type = i;
                                                this.Wi.add(remove);
                                                this.map.put(String.valueOf(i), Integer.valueOf(intValue));
                                                x(0, i);
                                                this.Wh.add(new c(0, string, i3));
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                if (this.Wg.moveToNext()) {
                                                }
                                            }
                                        } else {
                                            i = this.Wi.size();
                                            this.Wi.add(new c(i, substring, 0));
                                            this.map.put(String.valueOf(i), 1);
                                            this.Wh.add(new c(i, string, i3));
                                        }
                                    } else {
                                        i = i2;
                                        int i4 = 0;
                                        while (i4 < this.Wi.size()) {
                                            if (this.Wi.get(i4).path.equals(substring)) {
                                                i = this.Wi.get(i4).type;
                                                this.map.put(String.valueOf(i), Integer.valueOf(this.map.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i4++;
                                            i = i;
                                        }
                                        this.Wh.add(new c(i, string, i3));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (this.Wg.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (this.Wg != null) {
                    this.Wg.close();
                }
                this.Wg = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.Wg != null) {
                    this.Wg.close();
                }
                this.Wg = null;
            }
        }
    }

    private void x(int i, int i2) {
        if (this.Wh != null) {
            Iterator<c> it = this.Wh.iterator();
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
        for (int i = 0; i < this.Wi.size(); i++) {
            if (this.Wi.get(i).path.equals(str)) {
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
        Iterator<c> it = this.Wh.iterator();
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
        Iterator<c> it = this.Wh.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ() {
        if (Wp) {
            Wp = false;
            setResult(-1, u.sO().sR());
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
            sJ();
        }
    }
}
