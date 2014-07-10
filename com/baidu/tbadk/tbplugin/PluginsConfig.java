package com.baidu.tbadk.tbplugin;

import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ai;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginsConfig implements Serializable {
    public List<PluginConfig> plugin_config = new ArrayList();

    /* loaded from: classes.dex */
    public class Newest implements Serializable {
        public String changelog;
        public String md5;
        public boolean silent_upgrade;
        public int size;
        public String url;
        public int version;
    }

    private PluginsConfig() {
    }

    /* loaded from: classes.dex */
    public class PluginConfig implements ai, Serializable {
        public String description;
        public String icon;
        public String name;
        public Newest newest;
        public String verbose;
        public int[] versions;

        @Override // com.baidu.tbadk.core.util.ai
        public boolean isSupportImageSize() {
            return false;
        }

        @Override // com.baidu.tbadk.core.util.ai
        public LinkedList<String> getImageUrl() {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(this.icon);
            return linkedList;
        }

        @Override // com.baidu.tbadk.core.util.ai
        public LinkedList<ad> getImagesWithEmotions() {
            return null;
        }

        @Override // com.baidu.tbadk.core.util.ai
        public LinkedList<String> getPhotoUrl() {
            return null;
        }

        @Override // com.baidu.tbadk.core.util.ai
        public LinkedList<String> getForumPhotoUrl() {
            return null;
        }
    }

    public static PluginsConfig parse(String str) {
        try {
            return (PluginsConfig) new GsonBuilder().create().fromJson(str, (Class<Object>) PluginsConfig.class);
        } catch (Exception e) {
            return null;
        }
    }
}
