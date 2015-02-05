package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private boolean aYr = true;
    private ArrayList<String> aYs = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> aYt = new HashMap<>();
    private HashMap<String, Integer> aYu = new HashMap<>();

    public void Nh() {
        this.aYr = false;
    }

    public void Ni() {
        this.aYr = true;
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aYt.remove(gid);
                this.aYt.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aYs.add(gid);
                this.aYt.put(gid, imMessageCenterPojo);
                this.aYu.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.aYr && (size = this.aYs.size()) >= 4) {
                    for (String str : this.aYs.subList(0, size - 4)) {
                        this.aYs.remove(str);
                        this.aYt.remove(str);
                        this.aYu.remove(str);
                    }
                }
            }
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            gv(imMessageCenterPojo.getGid());
        }
    }

    public void gv(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYs.remove(str);
            this.aYs.add(str);
        }
    }

    public void gw(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYs.remove(str);
            this.aYu.remove(str);
            this.aYt.remove(str);
        }
    }

    public void removeAll() {
        this.aYs.clear();
        this.aYu.clear();
        this.aYt.clear();
    }

    public int Nj() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.aYt.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Nk() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.aYs.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.aYt.get(this.aYs.get(i));
                if (imMessageCenterPojo != null) {
                    arrayList.add(imMessageCenterPojo.getGroup_head());
                }
            }
        }
        return arrayList;
    }

    private boolean e(ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterPojo imMessageCenterPojo2;
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.aYt.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.aYu.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            gw(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (e(imMessageCenterPojo)) {
                b(imMessageCenterPojo);
                return 4;
            } else if (f(imMessageCenterPojo)) {
                if (this.aYs.contains(imMessageCenterPojo.getGid())) {
                    d(imMessageCenterPojo);
                    return 1;
                }
                c(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            gx(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Nm()) ? 6 : 0;
    }

    private void gx(String str) {
        if (!StringUtils.isNull(str) && this.aYu.containsKey(str)) {
            this.aYu.put(str, 0);
        }
    }

    public ArrayList<UserData> Nl() {
        if (this.aYs == null || this.aYs.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.aYs.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.aYt.get(this.aYs.get(i));
            if (imMessageCenterPojo != null) {
                UserData userData = new UserData();
                userData.setUserId(imMessageCenterPojo.getGid());
                userData.setUserName(imMessageCenterPojo.getGroup_name());
                userData.setPortrait(imMessageCenterPojo.getGroup_head());
                if (i == size - 1) {
                    userData.setConcern_num(0);
                } else {
                    userData.setConcern_num(imMessageCenterPojo.getUnread_count());
                }
                userData.setIsFriend(imMessageCenterPojo.getIsFriend());
                arrayList.add(userData);
            }
        }
        return arrayList;
    }

    public boolean Nm() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.aYt.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.aYs.remove(value.getGid());
                this.aYu.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Nn() {
        return (this.aYs == null || this.aYs.isEmpty()) ? false : true;
    }
}
