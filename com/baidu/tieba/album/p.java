package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public final class p {
    private WriteImagesInfo a;
    private String b;
    private List<ImageFileInfo> c;
    private int d;

    public final void a(ImageFileInfo imageFileInfo) {
        if (this.a == null) {
            this.a = new WriteImagesInfo();
        }
        this.a.addChooseFile(imageFileInfo);
    }

    public final void b(ImageFileInfo imageFileInfo) {
        if (this.a != null) {
            this.a.delChooseFile(imageFileInfo);
        }
    }

    public final boolean c(ImageFileInfo imageFileInfo) {
        if (this.a == null) {
            return false;
        }
        return this.a.isAdded(imageFileInfo);
    }

    public final List<ImageFileInfo> a() {
        if (this.a != null) {
            return this.a.getChosedFiles();
        }
        return null;
    }

    public final WriteImagesInfo b() {
        return this.a;
    }

    public final void a(WriteImagesInfo writeImagesInfo) {
        this.a = writeImagesInfo;
    }

    public final String c() {
        if (this.a != null) {
            return this.a.getLastAlbumId();
        }
        return null;
    }

    public final void a(String str) {
        if (this.a == null) {
            this.a = new WriteImagesInfo();
        }
        this.a.setLastAlbumId(str);
    }

    public final int d() {
        if (this.a != null) {
            return this.a.getMaxImagesAllowed();
        }
        return 0;
    }

    public final String e() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final List<ImageFileInfo> f() {
        return this.c;
    }

    public final void a(List<ImageFileInfo> list) {
        this.c = list;
    }

    public final int g() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int h() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }
}
