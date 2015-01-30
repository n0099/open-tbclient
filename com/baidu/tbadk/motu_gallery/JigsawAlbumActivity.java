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
    private static boolean acR = false;
    private static boolean acS = true;
    private Cursor acJ;
    private j acN;
    private ListView acO;
    private u acP;
    private l acQ;
    TextView acY;
    private LinearLayout acZ;
    private ArrayList<c> acK = new ArrayList<>();
    private ArrayList<c> acL = new ArrayList<>();
    private Map<String, Integer> map = new HashMap();
    private Map<String, Bitmap> acM = new LinkedHashMap();
    private NavigationBar mNavigationBar = null;
    private final int acT = 0;
    private final int acU = 1;
    private final int acV = 2;
    private byte[] acW = new byte[1];
    private boolean acX = false;
    private Handler mHandler = new Handler(new d(this));
    private Runnable mRunnable = new e(this);
    int ada = 0;
    int adb = 0;

    public boolean wA() {
        return acR;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (wA()) {
            acR = false;
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
        this.acY = (TextView) findViewById(com.baidu.tieba.w.jigsaw_selected_text);
        this.acP = u.wG();
        this.acP.Y(getPageContext().getPageActivity());
        this.acO = (ListView) findViewById(com.baidu.tieba.w.albums_list);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.jigsaw_photo_storage));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_textbtn, new g(this))).setText(z.jigsaw_start);
        this.acN = new j(this, getPageContext().getPageActivity());
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.acO.setAdapter((ListAdapter) this.acN);
        this.acO.setOnItemClickListener(new h(this));
        this.acZ = (LinearLayout) findViewById(com.baidu.tieba.w.selected_ll);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        acS = true;
        this.acX = false;
        this.acY.setText(this.acP.ab(getPageContext().getPageActivity()));
        if (this.acP.wI()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        wB();
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void wB() {
        this.acZ.removeAllViews();
        for (Uri uri : this.acP.Z(getPageContext().getPageActivity())) {
            w wVar = new w(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth), (int) getResources().getDimension(com.baidu.tieba.u.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.h(uri)) {
                this.acZ.addView(wVar);
                wVar.setOnClickListener(new i(this, wVar));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.acM.clear();
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
        synchronized (this.acW) {
            try {
                this.acK.clear();
                this.acL.clear();
                this.acJ = null;
                this.acJ = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (this.acJ != null && this.acJ.getCount() > 0) {
                    this.acJ.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = this.acJ.getString(this.acJ.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = this.acJ.getInt(this.acJ.getColumnIndexOrThrow("_id"));
                                if (ew(this.acJ.getString(this.acJ.getColumnIndexOrThrow("_display_name"))) < 0) {
                                    i = i2;
                                } else {
                                    String substring = string.substring(0, string.lastIndexOf("/"));
                                    if (!ev(substring)) {
                                        if (substring != null && substring.endsWith(TbConfig.getTempDirName()) && !this.acL.isEmpty()) {
                                            c remove = this.acL.remove(0);
                                            this.acL.add(0, new c(0, substring, 0));
                                            int intValue = this.map.get(String.valueOf(0)).intValue();
                                            this.map.put(String.valueOf(0), 1);
                                            i = this.acL.size();
                                            try {
                                                remove.type = i;
                                                this.acL.add(remove);
                                                this.map.put(String.valueOf(i), Integer.valueOf(intValue));
                                                A(0, i);
                                                this.acK.add(new c(0, string, i3));
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                if (this.acJ.moveToNext()) {
                                                }
                                            }
                                        } else {
                                            i = this.acL.size();
                                            this.acL.add(new c(i, substring, 0));
                                            this.map.put(String.valueOf(i), 1);
                                            this.acK.add(new c(i, string, i3));
                                        }
                                    } else {
                                        i = i2;
                                        int i4 = 0;
                                        while (i4 < this.acL.size()) {
                                            if (this.acL.get(i4).path.equals(substring)) {
                                                i = this.acL.get(i4).type;
                                                this.map.put(String.valueOf(i), Integer.valueOf(this.map.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i4++;
                                            i = i;
                                        }
                                        this.acK.add(new c(i, string, i3));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (this.acJ.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (this.acJ != null) {
                    this.acJ.close();
                }
                this.acJ = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.acJ != null) {
                    this.acJ.close();
                }
                this.acJ = null;
            }
        }
    }

    private void A(int i, int i2) {
        if (this.acK != null) {
            Iterator<c> it = this.acK.iterator();
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
        for (int i = 0; i < this.acL.size(); i++) {
            if (this.acL.get(i).path.equals(str)) {
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
    public String dB(int i) {
        Iterator<c> it = this.acK.iterator();
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
        Iterator<c> it = this.acK.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.type == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        if (acS) {
            acS = false;
            setResult(-1, u.wG().wJ());
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
            wC();
        }
    }
}
