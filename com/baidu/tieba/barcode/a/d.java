package com.baidu.tieba.barcode.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    private final Context a;
    private Point b;
    private Point c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width <= height) {
            height = width;
            width = height;
        }
        this.b = new Point(height, width);
        Point point = new Point();
        point.x = this.b.x;
        point.y = this.b.y;
        if (this.b.x < this.b.y) {
            point.x = this.b.y;
            point.y = this.b.x;
        }
        this.c = a(parameters, point);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            com.baidu.adp.lib.g.e.c(getClass().getName(), "setDesiredCameraParameters", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        com.baidu.adp.lib.g.e.a(getClass().getName(), "setDesiredCameraParameters", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            com.baidu.adp.lib.g.e.c(getClass().getName(), "setDesiredCameraParameters", "In camera config safe mode -- most settings will not be honored");
        }
        String a = a(parameters.getSupportedFocusModes(), "auto");
        if (!z && a == null) {
            a = a(parameters.getSupportedFocusModes(), "macro", "edof");
        }
        if (a != null) {
            parameters.setFocusMode(a);
        }
        parameters.setPreviewSize(this.c.x, this.c.y);
        if (Build.VERSION.SDK_INT >= 8) {
            CompatibleUtile.getInstance().setCameraDisplayOrientation(camera, 90);
        } else {
            parameters.set("orientation", "portrait");
            parameters.set("rotation", 90);
        }
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point b() {
        return this.b;
    }

    private Point a(Camera.Parameters parameters, Point point) {
        Point point2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            com.baidu.adp.lib.g.e.c(getClass().getName(), "findBestPreviewSizeValue", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new e(this));
        Point point3 = null;
        float f = point.x / point.y;
        float f2 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i = size.width;
            int i2 = size.height;
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 1024000) {
                boolean z = i < i2;
                int i4 = z ? i2 : i;
                int i5 = z ? i : i2;
                if (i4 == point.x && i5 == point.y) {
                    Point point4 = new Point(i, i2);
                    com.baidu.adp.lib.g.e.a(getClass().getName(), "sort", "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
                float abs = Math.abs((i4 / i5) - f);
                if (abs < f2) {
                    point2 = new Point(i, i2);
                } else {
                    abs = f2;
                    point2 = point3;
                }
                point3 = point2;
                f2 = abs;
            }
        }
        if (point3 == null) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            point3 = new Point(previewSize2.width, previewSize2.height);
            com.baidu.adp.lib.g.e.a(getClass().getName(), "sort", "No suitable preview sizes, using default: " + point3);
        }
        com.baidu.adp.lib.g.e.a(getClass().getName(), "sort", "Found best approximate preview size: " + point3);
        return point3;
    }

    private static String a(Collection<String> collection, String... strArr) {
        String str;
        com.baidu.adp.lib.g.e.a("CameraConfiguration", "findSettableValue", "Supported values: " + collection);
        if (collection != null) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                str = strArr[i];
                if (collection.contains(str)) {
                    break;
                }
            }
        }
        str = null;
        com.baidu.adp.lib.g.e.a("CameraConfiguration", "findSettableValue", "Settable value: " + str);
        return str;
    }
}
