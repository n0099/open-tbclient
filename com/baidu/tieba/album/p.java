package com.baidu.tieba.album;

import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private WriteImagesInfo a;
    private String b;
    private List<ImageFileInfo> c;
    private int d;

    public void a(ImageFileInfo imageFileInfo) {
        if (this.a == null) {
            this.a = new WriteImagesInfo();
        }
        this.a.addChooseFile(imageFileInfo);
    }

    public void b(ImageFileInfo imageFileInfo) {
        if (this.a != null) {
            this.a.delChooseFile(imageFileInfo);
        }
    }

    public boolean c(ImageFileInfo imageFileInfo) {
        if (this.a == null) {
            return false;
        }
        return this.a.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> a() {
        if (this.a != null) {
            return this.a.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo b() {
        return this.a;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.a = writeImagesInfo;
    }

    public String c() {
        if (this.a != null) {
            return this.a.getLastAlbumId();
        }
        return null;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new WriteImagesInfo();
        }
        this.a.setLastAlbumId(str);
    }

    public int d() {
        if (this.a != null) {
            return this.a.getMaxImagesAllowed();
        }
        return 0;
    }

    public String e() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public List<ImageFileInfo> f() {
        return this.c;
    }

    public void a(List<ImageFileInfo> list) {
        this.c = list;
    }

    public int g() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int h() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }
}
