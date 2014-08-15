package com.baidu.tbadk.pluginArch.bean;

import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConfigInfos implements Serializable {
    private static final long serialVersionUID = 2500429455834004772L;
    private List<PluginConfig> plugin_config = new ArrayList();

    /* loaded from: classes.dex */
    public class Newest implements Serializable {
        private static final long serialVersionUID = 8713611233991534353L;
        public String changelog;
        public String md5;
        public boolean silent_upgrade;
        public int size;
        public String url;
        public int version;
    }

    public List<PluginConfig> getConfigs() {
        return this.plugin_config;
    }

    /* loaded from: classes.dex */
    public class PluginConfig implements aa, Serializable {
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

        public LinkedList<String> getImageUrl() {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(this.icon);
            return linkedList;
        }

        public LinkedList<ImageInfo> getImagesWithEmotions() {
            return null;
        }

        public LinkedList<String> getPhotoUrl() {
            return null;
        }

        public LinkedList<String> getForumPhotoUrl() {
            return null;
        }
    }

    public static ConfigInfos parse(String str) {
        try {
            return (ConfigInfos) new GsonBuilder().create().fromJson(str, (Class<Object>) ConfigInfos.class);
        } catch (Exception e) {
            return null;
        }
    }
}
