package com.baidu.tieba.aiapps.apps.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.b;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private static final boolean DEBUG = b.DEBUG;
    private BdContextMenuView djR;

    public a(View view) {
        super(view);
        dD(view.getResources().getDimensionPixelSize(R.dimen.aiapps_context_menu_max_width));
        cl(true);
        cm(true);
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        BdContextMenuView bdContextMenuView = new BdContextMenuView(context);
        this.djR = bdContextMenuView;
        return bdContextMenuView;
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (DEBUG) {
            Log.d("BdContextMenu", "Ensure menu loaded!");
        }
        ((BdContextMenuView) view).layoutMenu(list);
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void showMenu(PopupWindow popupWindow) {
        if (DEBUG) {
            Log.d("BdContextMenu", "Show menu!");
        }
        popupWindow.showAtLocation(this.mViewToAttach, 17, 0, 0);
    }
}
