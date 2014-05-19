package com.baidu.tbadk.tbplugin;

import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginsConfig implements Serializable {
    public List<PluginConfig> plugin_config = new ArrayList();

    private PluginsConfig() {
    }

    /* loaded from: classes.dex */
    public class Newest implements Serializable {
        public String changelog;
        public String md5;
        public boolean silent_upgrade;
        public int size;
        public String url;
        public int version;

        public String toString() {
            return "Newest{version=" + this.version + ", changelog='" + this.changelog + "', url='" + this.url + "', md5='" + this.md5 + "', size=" + this.size + ", silent_upgrade=" + this.silent_upgrade + '}';
        }
    }

    /* loaded from: classes.dex */
    public class PluginConfig implements ad, Serializable {
        public String description;
        public String icon;
        public String name;
        public Newest newest;
        public String verbose;
        public int[] versions;

        public String toString() {
            return "PluginConfig{name='" + this.name + "', description='" + this.description + "', verbose='" + this.verbose + "', versions=" + Arrays.toString(this.versions) + ", newest=" + this.newest + '}';
        }

        @Override // com.baidu.tbadk.core.util.ad
        public boolean isSupportImageSize() {
            return false;
        }

        @Override // com.baidu.tbadk.core.util.ad
        public LinkedList<String> getImageUrl() {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(this.icon);
            return linkedList;
        }

        @Override // com.baidu.tbadk.core.util.ad
        public LinkedList<ab> getImagesWithEmotions() {
            return null;
        }

        @Override // com.baidu.tbadk.core.util.ad
        public LinkedList<String> getPhotoUrl() {
            return null;
        }

        @Override // com.baidu.tbadk.core.util.ad
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

    public String toString() {
        return "PluginsConfig{plugin_config=" + this.plugin_config + '}';
    }
}
