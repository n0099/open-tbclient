package com.baidu.tbadk.motu_gallery;

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
    private static boolean acO = false;
    private static boolean acP = true;
    private Cursor acG;
    private j acK;
    private ListView acL;
    private u acM;
    private l acN;
    TextView acV;
    private LinearLayout acW;
    private ArrayList<c> acH = new ArrayList<>();
    private ArrayList<c> acI = new ArrayList<>();
    private Map<String, Integer> map = new HashMap();
    private Map<String, Bitmap> acJ = new LinkedHashMap();
    private NavigationBar mNavigationBar = null;
    private final int acQ = 0;
    private final int acR = 1;
    private final int acS = 2;
    private byte[] acT = new byte[1];
    private boolean acU = false;
    private Handler mHandler = new Handler(new d(this));
    private Runnable mRunnable = new e(this);
    int acX = 0;
    int acY = 0;

    public boolean wu() {
        return acO;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wu()) {
            acO = false;
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
            x.showToastLong(z.oom_retry);
        }
        this.acV = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.acM = u.wA();
        this.acM.Y(getPageContext().getPageActivity());
        this.acL = (ListView) findViewById(com.baidu.tieba.w.albums_list);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.jigsaw_photo_storage));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new g(this))).setText(z.jigsaw_start);
        this.acK = new j(this, getPageContext().getPageActivity());
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.acL.setAdapter((ListAdapter) this.acK);
        this.acL.setOnItemClickListener(new h(this));
        this.acW = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        acP = true;
        this.acU = false;
        this.acV.setText(this.acM.ab(getPageContext().getPageActivity()));
        if (this.acM.wC()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        wv();
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void wv() {
        this.acW.removeAllViews();
        for (Uri uri : this.acM.Z(getPageContext().getPageActivity())) {
            w wVar = new w(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.h(uri)) {
                this.acW.addView(wVar);
                wVar.setOnClickListener(new i(this, wVar));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.acJ.clear();
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
        synchronized (this.acT) {
            try {
                this.acH.clear();
                this.acI.clear();
                this.acG = null;
                this.acG = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (this.acG != null && this.acG.getCount() > 0) {
                    this.acG.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = this.acG.getString(this.acG.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = this.acG.getInt(this.acG.getColumnIndexOrThrow("_id"));
                                if (et(this.acG.getString(this.acG.getColumnIndexOrThrow("_display_name"))) < 0) {
                                    i = i2;
                                } else {
                                    String substring = string.substring(0, string.lastIndexOf("/"));
                                    if (!es(substring)) {
                                        if (substring != null && substring.endsWith(TbConfig.getTempDirName()) && !this.acI.isEmpty()) {
                                            c remove = this.acI.remove(0);
                                            this.acI.add(0, new c(0, substring, 0));
                                            int intValue = this.map.get(String.valueOf(0)).intValue();
                                            this.map.put(String.valueOf(0), 1);
                                            i = this.acI.size();
                                            try {
                                                remove.type = i;
                                                this.acI.add(remove);
                                                this.map.put(String.valueOf(i), Integer.valueOf(intValue));
                                                A(0, i);
                                                this.acH.add(new c(0, string, i3));
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                if (this.acG.moveToNext()) {
                                                }
                                            }
                                        } else {
                                            i = this.acI.size();
                                            this.acI.add(new c(i, substring, 0));
                                            this.map.put(String.valueOf(i), 1);
                                            this.acH.add(new c(i, string, i3));
                                        }
                                    } else {
                                        i = i2;
                                        int i4 = 0;
                                        while (i4 < this.acI.size()) {
                                            if (this.acI.get(i4).path.equals(substring)) {
                                                i = this.acI.get(i4).type;
                                                this.map.put(String.valueOf(i), Integer.valueOf(this.map.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i4++;
                                            i = i;
                                        }
                                        this.acH.add(new c(i, string, i3));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (this.acG.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (this.acG != null) {
                    this.acG.close();
                }
                this.acG = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.acG != null) {
                    this.acG.close();
                }
                this.acG = null;
            }
        }
    }

    private void A(int i, int i2) {
        if (this.acH != null) {
            Iterator<c> it = this.acH.iterator();
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

    private boolean es(String str) {
        for (int i = 0; i < this.acI.size(); i++) {
            if (this.acI.get(i).path.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int et(String str) {
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
    public String dB(int i) {
        Iterator<c> it = this.acH.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next.path;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c dC(int i) {
        Iterator<c> it = this.acH.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        if (acP) {
            acP = false;
            setResult(-1, u.wA().wD());
            finish();
        }
    }

    public int t(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (10 == i && 2 == i2) {
            ww();
        }
    }
}
