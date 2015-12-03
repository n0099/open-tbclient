package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.FoundNew.Banner;
import tbclient.FoundNew.FoundNewResIdl;
import tbclient.FoundNew.Menu;
import tbclient.FoundNew.Module;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.b, j {
    private long aOo;
    private Banner aOp;
    private List<d> aOq;

    public long IU() {
        return this.aOo;
    }

    public Banner IV() {
        return this.aOp;
    }

    public List<d> IW() {
        return this.aOq;
    }

    public void H(List<d> list) {
        this.aOq = list;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "FoundNewData";
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof FoundNewResIdl) {
            FoundNewResIdl foundNewResIdl = (FoundNewResIdl) message;
            if (foundNewResIdl.error.errorno.intValue() == 0 && foundNewResIdl.data != null) {
                if (foundNewResIdl.data.timestamp != null) {
                    this.aOo = foundNewResIdl.data.timestamp.longValue();
                }
                this.aOp = foundNewResIdl.data.banner;
                List<Module> list = foundNewResIdl.data.module;
                this.aOq = new ArrayList(0);
                if (list != null && !list.isEmpty()) {
                    for (Module module : list) {
                        if (module != null && module.menu_list != null && module.menu_list.size() > 0) {
                            d dVar = new d();
                            dVar.setType(module.type == null ? 0 : module.type.intValue());
                            ArrayList arrayList = new ArrayList(0);
                            dVar.I(arrayList);
                            for (Menu menu : module.menu_list) {
                                if (menu != null) {
                                    arrayList.add(new c().a(menu));
                                }
                            }
                            this.aOq.add(dVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Dq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
        try {
            a((FoundNewResIdl) new Wire(new Class[0]).parseFrom(bArr, FoundNewResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
