package com.baidu.tbadk.pluginArch.bean;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ConfigInfos extends i implements Serializable {
    private static final long serialVersionUID = 2500429455834004772L;
    private String config_version;
    private List<PluginConfig> plugin_config = new ArrayList();

    /* loaded from: classes.dex */
    public class Newest extends i implements Serializable {
        private static final long serialVersionUID = 8713611233991534353L;
        public String changelog;
        public String md5;
        public int silent_upgrade;
        public int size;
        public String url;
        public int version;
    }

    public String getConfig_version() {
        return this.config_version;
    }

    public List<PluginConfig> getConfigs() {
        return this.plugin_config;
    }

    /* loaded from: classes.dex */
    public class PluginConfig extends i implements z, Serializable {
        private static final long serialVersionUID = -5184076118455114028L;
        public String description;
        public String icon;
        public String name;
        public Newest newest;
        public String verbose;
        public int[] versions;

        public boolean isSupportImageSize() {
            return false;
        }

        public ArrayList<String> getImageUrl() {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.icon);
            return arrayList;
        }

        public ArrayList<ImageInfo> getImagesWithEmotions() {
            return null;
        }

        public ArrayList<String> getPhotoUrl() {
            return null;
        }

        public ArrayList<String> getForumPhotoUrl() {
            return null;
        }
    }

    public static ConfigInfos parse(String str) {
        try {
            return (ConfigInfos) i.objectWithJsonStr(str, ConfigInfos.class);
        } catch (Exception e) {
            return null;
        }
    }
}
