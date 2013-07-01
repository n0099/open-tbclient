package com.baidu.tieba.data;

import com.baidu.mapapi.GeoPoint;
import com.baidu.tieba.nearby.MapOverlayItem;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapPostItem implements Serializable {
    private static final long serialVersionUID = 1038675805751106118L;
    private int lat;
    private int lng;
    private String mThreadId = null;
    private String mTitle = null;
    private String mContent = null;
    private MetaData mAutor = null;

    public MapPostItem(int i, int i2) {
        this.lat = 0;
        this.lng = 0;
        this.lat = i;
        this.lng = i2;
    }

    public void setAutor(MetaData metaData) {
        this.mAutor = metaData;
    }

    public MetaData getAutor() {
        return this.mAutor;
    }

    public String getPostId() {
        return this.mThreadId;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public int getLat() {
        return this.lat;
    }

    public void setLat(int i) {
        this.lat = i;
    }

    public int getLng() {
        return this.lng;
    }

    public void setLng(int i) {
        this.lng = i;
    }

    public MapOverlayItem getOverlayItem() {
        MapOverlayItem mapOverlayItem = new MapOverlayItem(new GeoPoint(getLat(), getLng()), getTitle(), getContent());
        mapOverlayItem.a(this);
        return mapOverlayItem;
    }
}
