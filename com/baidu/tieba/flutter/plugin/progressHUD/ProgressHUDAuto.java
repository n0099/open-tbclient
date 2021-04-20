package com.baidu.tieba.flutter.plugin.progressHUD;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class ProgressHUDAuto {

    /* loaded from: classes4.dex */
    public static class AttentionTimeParam {
        public String status;
        public Double time;

        public static AttentionTimeParam fromMap(HashMap hashMap) {
            AttentionTimeParam attentionTimeParam = new AttentionTimeParam();
            attentionTimeParam.status = (String) hashMap.get("status");
            attentionTimeParam.time = (Double) hashMap.get("time");
            return attentionTimeParam;
        }

        public String getStatus() {
            return this.status;
        }

        public Double getTime() {
            return this.time;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setTime(Double d2) {
            this.time = d2;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("status", this.status);
            hashMap.put("time", this.time);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostProgressHUD {
        void showAttentionWithStatus(StringParam stringParam);

        void showAttentionWithStatusForTime(AttentionTimeParam attentionTimeParam);

        void showErrorWithStatus(StringParam stringParam);

        void showSuccessWithStatus(StringParam stringParam);

        void showWithImg(ImageParam imageParam);
    }

    /* loaded from: classes4.dex */
    public static class ImageParam {
        public String image;
        public Boolean isSvg;
        public String text;

        public static ImageParam fromMap(HashMap hashMap) {
            ImageParam imageParam = new ImageParam();
            imageParam.image = (String) hashMap.get("image");
            imageParam.text = (String) hashMap.get("text");
            imageParam.isSvg = (Boolean) hashMap.get("isSvg");
            return imageParam;
        }

        public String getImage() {
            return this.image;
        }

        public Boolean getIsSvg() {
            return this.isSvg;
        }

        public String getText() {
            return this.text;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setIsSvg(Boolean bool) {
            this.isSvg = bool;
        }

        public void setText(String str) {
            this.text = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("image", this.image);
            hashMap.put("text", this.text);
            hashMap.put("isSvg", this.isSvg);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class StringParam {
        public String status;

        public static StringParam fromMap(HashMap hashMap) {
            StringParam stringParam = new StringParam();
            stringParam.status = (String) hashMap.get("status");
            return stringParam;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("status", this.status);
            return hashMap;
        }
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
