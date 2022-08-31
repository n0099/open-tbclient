package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tieba.c26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e26 implements c26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public d b;
    public c26.a c;
    public TbPageContext d;
    public VideoMuxer e;
    public CustomMessageListener f;
    public Runnable g;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e26 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e26 e26Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e26Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e26Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e26 a;

        public b(e26 e26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e26Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f89 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e26 a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public a(c cVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        public c(e26 e26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e26Var;
        }

        @Override // com.baidu.tieba.f89
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.f89
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                qc9.a().post(new a(this, new CustomResponsedMessage(2921584, Integer.valueOf(i))));
            }
        }

        @Override // com.baidu.tieba.f89
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                qc9.a().post(this.a.g);
                if (this.a.c != null) {
                    this.a.c.a();
                }
            }
        }

        @Override // com.baidu.tieba.f89
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                qc9.a().post(this.a.g);
                if (this.a.c != null) {
                    this.a.c.c(str);
                }
            }
        }

        @Override // com.baidu.tieba.f89
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                qc9.a().post(this.a.g);
                if (this.a.c != null) {
                    this.a.c.a();
                }
            }
        }

        @Override // com.baidu.tieba.f89
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.b();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<List<String>, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public xa9 b;
        public final /* synthetic */ e26 c;

        /* loaded from: classes3.dex */
        public class a implements xa9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.xa9
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.tieba.xa9
            public void b(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                }
            }

            @Override // com.baidu.tieba.xa9
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                }
            }
        }

        public d(e26 e26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e26Var;
            this.b = new a(this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x010d, code lost:
            if (com.baidu.tieba.tc9.h(r6, r7[0], r1, r5.b) != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x011d A[LOOP:0: B:52:0x0117->B:54:0x011d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x012f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0130 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(StringBuilder sb, List<String>[] listArr) {
            InterceptResult invokeLL;
            List<String> list;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, sb, listArr)) != null) {
                return (String) invokeLL.objValue;
            }
            if (listArr[0] == null || listArr[0].size() == 0) {
                if (sb != null) {
                    sb.append("拍摄视频页需要拼接文件列表为空");
                    return null;
                }
                return null;
            }
            String str = ws8.f + "rec_tmp_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            if (!StringUtils.isNull(str)) {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
            }
            boolean z2 = true;
            try {
                if (listArr[0].size() == 1) {
                    try {
                        z = ls8.b(listArr[0].get(0), str, this.b);
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (sb != null) {
                            sb.append(e.toString());
                        }
                        if (FileHelper.CheckFile(listArr[0].get(0))) {
                            list = listArr[0];
                        }
                        z = false;
                        if (!z) {
                        }
                        while (r6.hasNext()) {
                        }
                        if (z2) {
                        }
                    } catch (Exception e2) {
                        if (sb != null) {
                            sb.append(e2.toString());
                        }
                        if (FileHelper.CheckFile(listArr[0].get(0))) {
                            list = listArr[0];
                        }
                        z = false;
                        if (!z) {
                        }
                        while (r6.hasNext()) {
                        }
                        if (z2) {
                        }
                    }
                    if (!z && FileHelper.CheckFile(listArr[0].get(0))) {
                        list = listArr[0];
                        str = list.get(0);
                        z = true;
                    }
                    if (!z) {
                        boolean isExists = FileUtils.isExists(listArr[0].get(0));
                        if (sb != null) {
                            sb.append(" 源文件存在 ： ");
                            sb.append(isExists);
                            sb.append(" , 拍摄视频页不需要拼接时复制失败 from ");
                            sb.append(listArr[0].get(0));
                            sb.append("to ");
                            sb.append(str);
                        }
                        z2 = false;
                    }
                    for (String str2 : listArr[0]) {
                        this.c.a.add(str2);
                    }
                    return z2 ? str : "";
                }
            } catch (Throwable th) {
                if (FileHelper.CheckFile(listArr[0].get(0))) {
                    listArr[0].get(0);
                }
                throw th;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cancel(true);
                if (this.c.c != null) {
                    this.c.c.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (this.c.c != null) {
                    this.c.c.b();
                }
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, listArr)) == null) {
                if (ListUtils.isEmpty(listArr[0])) {
                    return "";
                }
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.clear();
                this.a.addAll(listArr[0]);
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    if (wa9.a(it.next()) <= 0) {
                        return "";
                    }
                }
                return b(new StringBuilder(), listArr);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                super.onPostExecute((d) str);
                xa9 xa9Var = this.b;
                if (xa9Var != null) {
                    xa9Var.a();
                }
                if (this.c.c != null) {
                    this.c.c.c(str);
                }
            }
        }

        public /* synthetic */ d(e26 e26Var, a aVar) {
            this(e26Var);
        }
    }

    public e26(TbPageContext tbPageContext, c26.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f = new a(this, 2921585);
        this.g = new b(this);
        this.d = tbPageContext;
        this.c = aVar;
    }

    @Override // com.baidu.tieba.c26
    public boolean a(d26 d26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d26Var)) == null) {
            if (d26Var == null) {
                return false;
            }
            int f = d26Var.f();
            int e = d26Var.e();
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setRecordConfigEncodeHevcVideo(true);
            videoMuxerData.setCurrentEncodeHevcVideo(true);
            ArrayList arrayList = new ArrayList();
            if (d26Var.c() != null) {
                TbMultiMediaData tbMultiMediaData = (TbMultiMediaData) d26Var.c().clone();
                tbMultiMediaData.textureId = 0;
                arrayList.add(tbMultiMediaData);
                videoMuxerData.setPhotoDataList(arrayList);
                videoMuxerData.setVideoPath(tbMultiMediaData.path);
                videoMuxerData.setPreviewWidth(f);
                videoMuxerData.setPreviewHeight(e);
                videoMuxerData.setVideoRatio(d26Var.g());
                videoMuxerData.setOutWidth(f);
                videoMuxerData.setOutHeight(e);
                videoMuxerData.setOutBitRate(f * e * 6);
            }
            if (d26Var.a() != null) {
                videoMuxerData.setFilterValue(d26Var.a());
            }
            if (d26Var.b() != null) {
                videoMuxerData.setCurrThemeEffect(d26Var.b());
            }
            videoMuxerData.setUserNewAudioMixture(true);
            if (d26Var.d() != null) {
                videoMuxerData.setMusicData(d26Var.d());
                ArrayList arrayList2 = new ArrayList();
                AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
                AudioPlayData audioPlayData = new AudioPlayData(d26Var.d().localPath, 0, jc9.f(d26Var.d().localPath), 1.0f);
                ArrayList arrayList3 = new ArrayList();
                audioPlayTrackData.mAudioPlayDataList = arrayList3;
                arrayList3.add(audioPlayData);
                arrayList2.add(audioPlayTrackData);
                videoMuxerData.setAudioPlayTrackDataList(arrayList2);
            }
            videoMuxerData.setComposeNecessary(true);
            VideoMuxer videoMuxer = this.e;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
            VideoMuxer videoMuxer2 = new VideoMuxer();
            this.e = videoMuxer2;
            videoMuxer2.setListener(new c(this));
            MessageManager.getInstance().registerListener(this.f);
            this.e.startMuxer(videoMuxerData);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.c26
    public boolean b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (FileHelper.getAvailableSize() < 52428800) {
                BdToast.b(this.d.getPageActivity(), this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0a7e)).i();
                return false;
            }
            d dVar = this.b;
            if (dVar != null) {
                dVar.cancel();
            }
            if (h(list)) {
                d dVar2 = new d(this, null);
                this.b = dVar2;
                dVar2.execute(list);
            } else {
                BdToast.b(this.d.getPageActivity(), this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0a7f)).i();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.cancel();
            }
            VideoMuxer videoMuxer = this.e;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final boolean h(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            float f = 0.0f;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    f += jc9.f(str);
                }
            }
            return f >= 3000.0f;
        }
        return invokeL.booleanValue;
    }
}
