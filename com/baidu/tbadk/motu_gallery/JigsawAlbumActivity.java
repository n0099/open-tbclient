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
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class JigsawAlbumActivity extends BaseActivity<JigsawAlbumActivity> {
    private static boolean acu = false;
    private static boolean acv = true;
    TextView acB;
    private LinearLayout acC;
    private Cursor acl;
    private j acp;
    private ListView acq;
    private u acr;
    private l acs;
    private ArrayList<c> acm = new ArrayList<>();
    private ArrayList<c> acn = new ArrayList<>();
    private Map<String, Integer> map = new HashMap();
    private Map<String, Bitmap> aco = new LinkedHashMap();
    private NavigationBar mNavigationBar = null;
    private final int acw = 0;
    private final int acx = 1;
    private final int acy = 2;
    private byte[] acz = new byte[1];
    private boolean acA = false;
    private Handler mHandler = new Handler(new d(this));
    private Runnable mRunnable = new e(this);
    int acD = 0;
    int acE = 0;

    public static void h(Context context, int i) {
        Intent intent = new Intent(context, JigsawAlbumActivity.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    public boolean wk() {
        return acu;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wk()) {
            acu = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(com.baidu.tieba.x.motu_albums_activity);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            y.showToastLong(z.oom_retry);
        }
        this.acB = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.acr = u.wq();
        this.acr.Y(getPageContext().getPageActivity());
        this.acq = (ListView) findViewById(com.baidu.tieba.w.albums_list);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.jigsaw_photo_storage));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new g(this))).setText(z.jigsaw_start);
        this.acp = new j(this, getPageContext().getPageActivity());
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.acq.setAdapter((ListAdapter) this.acp);
        this.acq.setOnItemClickListener(new h(this));
        this.acC = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        acv = true;
        this.acA = false;
        this.acB.setText(this.acr.ab(getPageContext().getPageActivity()));
        if (this.acr.ws()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        wl();
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void wl() {
        this.acC.removeAllViews();
        for (Uri uri : this.acr.Z(getPageContext().getPageActivity())) {
            x xVar = new x(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            if (xVar.h(uri)) {
                this.acC.addView(xVar);
                xVar.setOnClickListener(new i(this, xVar));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.aco.clear();
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
        synchronized (this.acz) {
            try {
                this.acm.clear();
                this.acn.clear();
                this.acl = null;
                this.acl = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (this.acl != null && this.acl.getCount() > 0) {
                    this.acl.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = this.acl.getString(this.acl.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = this.acl.getInt(this.acl.getColumnIndexOrThrow("_id"));
                                if (ew(this.acl.getString(this.acl.getColumnIndexOrThrow("_display_name"))) < 0) {
                                    i = i2;
                                } else {
                                    String substring = string.substring(0, string.lastIndexOf("/"));
                                    if (!ev(substring)) {
                                        if (substring != null && substring.endsWith(TbConfig.getTempDirName()) && !this.acn.isEmpty()) {
                                            c remove = this.acn.remove(0);
                                            this.acn.add(0, new c(0, substring, 0));
                                            int intValue = this.map.get(String.valueOf(0)).intValue();
                                            this.map.put(String.valueOf(0), 1);
                                            i = this.acn.size();
                                            try {
                                                remove.type = i;
                                                this.acn.add(remove);
                                                this.map.put(String.valueOf(i), Integer.valueOf(intValue));
                                                A(0, i);
                                                this.acm.add(new c(0, string, i3));
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                if (this.acl.moveToNext()) {
                                                }
                                            }
                                        } else {
                                            i = this.acn.size();
                                            this.acn.add(new c(i, substring, 0));
                                            this.map.put(String.valueOf(i), 1);
                                            this.acm.add(new c(i, string, i3));
                                        }
                                    } else {
                                        i = i2;
                                        int i4 = 0;
                                        while (i4 < this.acn.size()) {
                                            if (this.acn.get(i4).path.equals(substring)) {
                                                i = this.acn.get(i4).type;
                                                this.map.put(String.valueOf(i), Integer.valueOf(this.map.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i4++;
                                            i = i;
                                        }
                                        this.acm.add(new c(i, string, i3));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (this.acl.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (this.acl != null) {
                    this.acl.close();
                }
                this.acl = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.acl != null) {
                    this.acl.close();
                }
                this.acl = null;
            }
        }
    }

    private void A(int i, int i2) {
        if (this.acm != null) {
            Iterator<c> it = this.acm.iterator();
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

    private boolean ev(String str) {
        for (int i = 0; i < this.acn.size(); i++) {
            if (this.acn.get(i).path.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int ew(String str) {
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
    public String dv(int i) {
        Iterator<c> it = this.acm.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next.path;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c dw(int i) {
        Iterator<c> it = this.acm.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm() {
        if (acv) {
            acv = false;
            setResult(-1, u.wq().wt());
            finish();
        }
    }

    public int dip2px(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (10 == i && 2 == i2) {
            wm();
        }
    }
}
