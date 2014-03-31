package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class a extends Thread {
    private int a;
    private String b;
    private Hashtable<String, Integer> c;

    public a(Hashtable<String, Integer> hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public a(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList<String> a;
        super.run();
        try {
        } catch (Exception e) {
            f.b(getClass().getName(), "run", e.getMessage());
        }
        if (this.a == 3) {
            if (this.c != null && (a = y.a()) != null) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    this.c.put(a.get(i), 1);
                }
                return;
            }
            return;
        }
        if (this.a == 2) {
            String str = this.b;
            DatabaseManager databaseManager = new DatabaseManager();
            if (str != null) {
                try {
                    databaseManager.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                    return;
                } catch (Exception e2) {
                    f.b("DatabaseManager", "delFrsImageForum", e2.getMessage());
                    TiebaStatic.a(e2, "DatabaseManager.delFrsImageForum", new Object[0]);
                    return;
                }
            }
            return;
        } else if (this.a == 1) {
            String str2 = this.b;
            DatabaseManager databaseManager2 = new DatabaseManager();
            if (str2 != null) {
                try {
                    databaseManager2.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str2});
                    databaseManager2.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str2});
                    return;
                } catch (Exception e3) {
                    f.b("DatabaseManager", "insertFrsImageForum", e3.getMessage());
                    TiebaStatic.a(e3, "DatabaseManager.insertFrsImageForum", new Object[0]);
                    return;
                }
            }
            return;
        } else {
            return;
        }
        f.b(getClass().getName(), "run", e.getMessage());
    }
}
