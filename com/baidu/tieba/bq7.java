package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class bq7 implements fs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<yn> c;
    public boolean d;

    @Override // com.baidu.tieba.fs5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.fs5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public bq7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        if (dataRes.has_tornado.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            tq7 tq7Var = new tq7();
            tq7Var.e(dataRes.item_game_code);
            this.c.add(tq7Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                uq7 uq7Var = new uq7();
                uq7Var.d(dataRes.item_game_info.hot_videos);
                this.c.add(uq7Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !xi.isEmpty(recentUpdate.log)) {
                vq7 vq7Var = new vq7();
                vq7Var.d(dataRes.item_game_info.recent_update);
                this.c.add(vq7Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            rq7 rq7Var = new rq7();
            rq7Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(rq7Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    rq7 rq7Var2 = new rq7();
                    rq7Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(rq7Var2);
                }
            }
            rq7 rq7Var3 = new rq7();
            rq7Var3.d(this.a.id.intValue());
            rq7Var3.setPositionInFrsItemTab(i);
            rq7Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(rq7Var3);
        }
        sq7 sq7Var = new sq7();
        sq7Var.e(dataRes.item_info);
        if (sq7Var.d()) {
            this.c.add(sq7Var);
        }
        wq7 wq7Var = new wq7();
        wq7Var.d(dataRes.recommend_item);
        this.c.add(wq7Var);
    }
}
